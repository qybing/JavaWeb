package com.bank.service;

import java.util.List;



import com.bank.bean.Client;
import com.bank.bean.Teller;


public interface TellerService {
	
	Teller teller_login(String name,String password);
	void transferMoney(String fromName,String toName, Double money);
	List<Client> getAll();
	List<Client> findAllClients();
	void openAccount(Client client);
	
}
