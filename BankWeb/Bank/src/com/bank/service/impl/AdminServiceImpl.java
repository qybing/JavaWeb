package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.bank.bean.Admin;
import com.bank.dao.AdminDao;
import com.bank.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Resource()
	private AdminDao admindao;
	
	public void setAdmindao(AdminDao admindao) {
		this.admindao = admindao;
	}

	@Override
	public Admin admin_login(Admin admin) {
	/*	System.out.println(admin.getName());
		System.out.println(admin.getPassword());
		Admin admin2 = this.admindao.selectAdmin(admin);
		System.out.println(admin2);
		System.out.println("-------------");*/
		return this.admindao.selectAdmin(admin);
	}

	@Override
	public List<Admin> findAllAdmin() {

		return this.admindao.selectAllAdmin();
	}	
	
}




