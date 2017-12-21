package com.bank.controller;


import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.bean.Client;
import com.bank.bean.Teller;
import com.bank.service.TellerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/teller")
@Controller
public class TellerController {
	
	@Autowired
	@Resource(name="tellerService")
	private TellerService tellerService;

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
	
	@RequestMapping("/openAccount")
	public String openAccount(Client client) {
		tellerService.openAccount(client);
		return "main";
	}
	
	@RequestMapping(value="/transferMoney")
	public String transferMoney(HttpServletRequest req,
			HttpServletResponse res,String fromeName,String toName, Double money) {
		ModelAndView mv = new ModelAndView();
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
		List<Client> clients1 = tellerService.findAllClients();
		mv.addObject("clients1", clients1);
		//使用PageInfo包装查询的结果，只需将PageInfo交给界面就行了
		//封装了更详细的分页信息，包括我们查出来的数据
		PageInfo page = new PageInfo(clients,2);
		mv.addObject("PageInfo", page);
		
	/*	System.out.println(page.getPages());*/
		List<Client> client = page.getList();
		for (Client client2 : client) {
			System.out.println(client2);
		}
		
		model.addAttribute("PageInfo", page);
		mv.setViewName("Client_list");
		return mv; 
	}

	
}
