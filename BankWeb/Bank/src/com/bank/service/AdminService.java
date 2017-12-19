package com.bank.service;



import java.util.List;

import com.bank.bean.Admin;



public interface AdminService {

	 Admin admin_login(Admin admin);
	 List<Admin> findAllAdmin();
}
