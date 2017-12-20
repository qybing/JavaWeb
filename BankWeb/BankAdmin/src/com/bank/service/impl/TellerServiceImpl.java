package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.bean.Client;
import com.bank.bean.Teller;
import com.bank.dao.ClientDao;
import com.bank.dao.TellerDao;
import com.bank.service.TellerService;

@Service("tellerService")
@Transactional
public class TellerServiceImpl implements TellerService {

	@Resource
	private TellerDao tellerdao;
	
	@Resource
	private ClientDao clientDao;
	
	public void setTellerdao(TellerDao tellerdao) {
		this.tellerdao = tellerdao;
	}

	public Teller teller_login(String name, String password) {
		
		return tellerdao.selectByNameAndPassword(name, password);
	}

	@Override
	public void transferMoney(String A, String B, Double money) {
		tellerdao.updateAmonyById(A,1000d);
		int a = 1/0;
		tellerdao.updateBmonyById(B,1000d);
		System.out.println("转钱成功");
		
	}

	@Override
	public List<Client> getAll() {
		
		return clientDao.selectAllClients();
	}

}
