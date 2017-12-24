package com.bank.service;

import com.bank.bean.Client;

public interface ClientService {
	Client findClientById(Integer id);
	void updateClient(Client client);
}
