package com.bank.test;

import com.bank.untils.CreateImageCode;

public class ImageTest {

	
	public static void main(String[] args) {
	
		CreateImageCode cic=new CreateImageCode(200, 50, 6, 15);
		String code=cic.getCode();
		System.out.println(code);
	/*	cic.write(response.getOutputStream());*/
	}
}
