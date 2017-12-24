package com.bank.controller;



import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.bean.Client;
import com.bank.bean.Teller;
import com.bank.service.ClientService;
import com.bank.service.TellerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/teller")
@Controller
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
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		System.out.println("地址"+req.getServletPath());
		Teller teller = tellerService.teller_login(teller_id,password);
		mv.addObject("teller", teller);
		req.getSession().setAttribute("teller", teller);
		if(teller != null){
			mv.setViewName("main");
		}
		else {
			mv.setViewName("redirect:/error.jsp");
		}
		return mv;	
	}
	
	@RequestMapping(value="/openAccount",method=RequestMethod.POST)
	public String openAccount(Client client) {
		tellerService.openAccount(client);
		return "main";
	}
	
	@RequestMapping(value="/transferMoney")
	public String transferMoney(HttpServletRequest req,
			HttpServletResponse res,String fromeName,String toName, Double money) {
		
		tellerService.transferMoney(fromeName,toName,money);
	/*	mv.setViewName("redirect:/error.jsp");*/
		return "main";	
	}
	
	@RequestMapping(value="/clients")
	public ModelAndView getclients(@RequestParam(value="pn",defaultValue="1") Integer pn,
			Model model) {
		ModelAndView mv = new ModelAndView();
		//查询之前传入页码pn,1指代的是一页显示的记录条数
		PageHelper.startPage(pn, 2);
		List<Client> clients = tellerService.findAllClients();
		mv.addObject("clients", clients);
		//使用PageInfo包装查询的结果，只需将PageInfo交给界面就行了
		//封装了更详细的分页信息，包括我们查出来的数据
		PageInfo page = new PageInfo(clients,3);
		mv.addObject("PageInfo", page);	
		model.addAttribute("PageInfo", page);
		mv.setViewName("Client_list");
		return mv; 
	}
	
	@RequestMapping("/findClientById")
	public String findClientById(@RequestParam(value="acc_id") String acc_id,
			Model model) {
		Integer id = Integer.valueOf(acc_id);
		Client client = clientService.findClientById(id); 
		model.addAttribute("client", client);
		return "updateClient";
	}
	
	@RequestMapping("/updateClient")
	public String updateClient(Client client) {
		System.out.println(client);
		clientService.updateClient(client);
		return "Client_list";
	}
	
	
}
