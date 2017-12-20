package com.bank.dao;

import java.util.List;
import java.util.Map;

import com.bank.bean.Client;
import com.bank.bean.Teller;

public interface TellerDao {
	Teller selectByNameAndPassword(String name,String password);
	List<Client> selectAllClients(Client client);
	void updateAmonyById(String client_idA ,Double money);
	void updateBmonyById(String client_idB ,Double money);
	List<Client> selectAllClient();
}
