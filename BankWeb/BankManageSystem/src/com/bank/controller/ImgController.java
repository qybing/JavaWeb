package com.bank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.untils.CreateImageCode;



@Controller
public class ImgController {
	
	@RequestMapping("/getImgCode")
	public void getImgCode(HttpServletRequest request,HttpServletResponse response ) throws Exception {
		
		CreateImageCode cic=new CreateImageCode(200, 50, 6, 15);
		//获取本次验证码生成的字符串
		String code=cic.getCode();
		
		//将生成的验证码字符串，放到session域中
		request.getSession().setAttribute("checkcode", code);
		System.out.println(code);
		//将response的输出流传递给write方法
		cic.write(response.getOutputStream());	
	}

}
