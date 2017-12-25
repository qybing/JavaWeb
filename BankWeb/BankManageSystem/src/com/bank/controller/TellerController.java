package com.bank.controller;



import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bank.bean.Client;
import com.bank.bean.Teller;
import com.bank.service.ClientService;
import com.bank.service.TellerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/teller")

public class TellerController {
	
	@Autowired
	@Resource(name="tellerService")
	private TellerService tellerService;
	
	@Autowired
	@Qualifier("clientService")
	private ClientService clientService;
	
	public void setTellerService(TellerService tellerService) {
		this.tellerService = tellerService;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="username") String teller_id
			,@RequestParam(name="password") String password,
			HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		Teller teller = tellerService.teller_login(teller_id,password);
		if(teller != null){
			req.getSession().setAttribute("teller", teller);
			mv.addObject("teller", teller);
			mv.setViewName("admin/main");
		}
		else {
			mv.addObject("error", "账号或密码错误");
			mv.setViewName("forward:/login.jsp");
		}
		return mv;	
	}
	
	@RequestMapping(value="/openAccount",method=RequestMethod.POST)
	public String openAccount(Client client) {
		tellerService.openAccount(client);
		return "admin/main";
	}
	
	@RequestMapping(value="/transferMoney")
	public String transferMoney(HttpServletRequest req,
			HttpServletResponse res,String fromeName,String toName, Double money) {
		
		tellerService.transferMoney(fromeName,toName,money);
		return "admin/main";	
	}
	
	@RequestMapping(value="/clients")
	public ModelAndView getclients(@RequestParam(value="pn",defaultValue="1") Integer pn,
			Model model) {
		ModelAndView mv = new ModelAndView();
		//pn代表当前穿过来的页数，2指代的是当前页显示的记录条数
		PageHelper.startPage(pn, 2);
		List<Client> clients = tellerService.findAllClients();
		mv.addObject("clients", clients);
		//把所有查询得到的结果封装在pageInfo，3指代的是显示页数的导航
		PageInfo page = new PageInfo(clients,3);
		mv.addObject("PageInfo", page);	
		model.addAttribute("PageInfo", page);
		mv.setViewName("admin/Client_list");
		return mv; 
	}
	
	@RequestMapping("/findClientById")
	public String findClientById(@RequestParam(value="acc_id") String acc_id,
			Model model) {
		Integer id = Integer.valueOf(acc_id);
		Client client = clientService.findClientById(id); 
		model.addAttribute("client", client);
		return "admin/updateClient";
	}
	
	@RequestMapping("/updateClient")
	public String updateClient(Client client) {
		System.out.println(client);
		clientService.updateClient(client);
		return "admin/Client_list";
	}
	
	
}
