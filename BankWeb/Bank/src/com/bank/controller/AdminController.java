package com.bank.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.bean.Admin;
import com.bank.service.AdminService;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@Autowired
	@Resource(name="adminService")
	private AdminService adminservice;
	
	
	public void setAdminservice(AdminService adminservice) {
		this.adminservice = adminservice;
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(Admin admin) {
		ModelAndView mv = new ModelAndView();
		
		Admin admin1 = adminservice.admin_login(admin);
		if(admin1 != null){
			mv.setViewName("/WEB-INF/admin/welecome.jsp");
		}
		else {
			mv.setViewName("/index.jsp");
		}
		return mv;	
	}
	
	@RequestMapping(value="/findAllAdmin")
	public ModelAndView allAdmin() {
		ModelAndView mv = new ModelAndView();
		List<Admin> admins = adminservice.findAllAdmin();
		System.out.println("这是什么++++"+admins);
		mv.addObject("admins", admins);
		mv.setViewName("/WEB-INF/admin/admins.jsp");
		return mv;	
	}

}
