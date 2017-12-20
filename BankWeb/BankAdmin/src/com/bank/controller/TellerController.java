package com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView login(@RequestParam(name="name") String teller_id
			,@RequestParam(name="password") String password) {
		ModelAndView mv = new ModelAndView();
		
		Teller teller = tellerService.teller_login(teller_id,password);
		mv.addObject("teller", teller);
		if(teller != null){
			mv.setViewName("main");
		}
		else {
			mv.setViewName("redirect:/error.jsp");
		}
		return mv;	
	}
	
	
	@RequestMapping(value="/transferMoney")
	public ModelAndView transferMoney(HttpServletRequest req,
			HttpServletResponse res,String A,String B, Double money) {
		ModelAndView mv = new ModelAndView();
		tellerService.transferMoney(A,B,money);
		mv.setViewName("redirect:/error.jsp");
		return mv;	
	}
	
	@RequestMapping(value="/clients")
	public ModelAndView getclients(@RequestParam(value="pn",defaultValue="1") Integer pn,
			Model model) {
		ModelAndView mv = new ModelAndView();
		//查询之前传入页码pn,1指代的是一页显示的记录条数
		PageHelper.startPage(2, 2);
		List<Client> clients = tellerService.getAll();
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
