package com.bank.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.bank.bean.Client;
import com.bank.bean.Teller;


public interface TellerService {

	Teller teller_login(String name,String password);
	void transferMoney(String A,String B, Double money);
	List<Client> getAll();
	
}
