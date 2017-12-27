package com.bank.controller;



import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
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
			mv.addObject("error", "账号密码错误");
			mv.setViewName("forward:/login.jsp");
		}
		return mv;	
	}
	
	@RequestMapping(value="/openAccount",method=RequestMethod.POST)
	public String openAccount(Model model,Client client,MultipartFile file,HttpSession session) throws Exception{
		if(!file.isEmpty()) {
			String path = session.getServletContext().getRealPath("/images");
			System.out.println(path);
			client.setPath(path);
			String fileName = file.getOriginalFilename();
			File filepath = new File(path,fileName);
			if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
			file.transferTo(new File(path + File.separator + fileName));
			tellerService.openAccount(client);
			return "admin/main";
		}
		else {
			model.addAttribute("error", "头像上传失败");
			return "forward:/addClient.jsp";
		}
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
		//pn指带当前传入的页数，没有则默认为1，2指带当前显示的记录数为2条
		PageHelper.startPage(pn, 2);
		List<Client> clients = tellerService.findAllClients();
		mv.addObject("clients", clients);
		//指带查询结果，和导航页数
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
