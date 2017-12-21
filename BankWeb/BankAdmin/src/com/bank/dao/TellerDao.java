package com.bank.dao;

import java.util.List;


import com.bank.bean.Client;
import com.bank.bean.Teller;

public interface TellerDao {
	Teller selectByNameAndPassword(String name,String password);
	List<Client> selectAllClients(Client client);
	void updateAmonyById(String fromName ,Double money);
	void updateBmonyById(String toName ,Double money);
	List<Client> selectAllClient();
}
