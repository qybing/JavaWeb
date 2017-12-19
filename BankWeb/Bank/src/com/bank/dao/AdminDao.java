package com.bank.dao;

import java.util.List;

import com.bank.bean.Admin;


public interface AdminDao {
	Admin selectAdmin(Admin admin);
	List<Admin> selectAllAdmin();
	

}
