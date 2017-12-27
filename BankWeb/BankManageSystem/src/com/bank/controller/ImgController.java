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
		//��ȡ������֤�����ɵ��ַ���
		String code=cic.getCode();
		
		//�����ɵ���֤���ַ������ŵ�session����
		request.getSession().setAttribute("checkcode", code);
		System.out.println(code);
		//��response����������ݸ�write����
		cic.write(response.getOutputStream());	
	}

}
