package com.bank.dao;

import java.util.List;

import com.bank.bean.Client;

public interface ClientDao {
	List<Client> selectAllClients();
	
	
}
