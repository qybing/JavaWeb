package com.bank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class GetCodeController {
	
	@RequestMapping(value="/GetCode",method=RequestMethod.POST)
	public void GetCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String checkcode=(String) request.getSession().getAttribute("checkcode");
		response.getWriter().write(checkcode);
	}

}
