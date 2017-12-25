package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bean.Client;
import com.bank.dao.ClientDao;
import com.bank.service.ClientService;

@Service("clientService")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;
	
	
	@Override
	public Client findClientById(Integer id) {
		// TODO Auto-generated method stub
		return clientDao.selectClientById(id);
	}


	@Override
	public void updateClient(Client client) {
		clientDao.updataCleint(client);
		
	}

}
