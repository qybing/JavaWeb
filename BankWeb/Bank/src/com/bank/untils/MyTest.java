package com.bank.untils;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bank.bean.Admin;
import com.bank.service.AdminService;
import com.bank.service.impl.AdminServiceImpl;

public class MyTest {
		private AdminService adminService;
		
		@Before
		public void before() {
			adminService = new AdminServiceImpl();
		}
		
		@Test
		public void testInsert() {
			
			Admin admin = new Admin("admin","1");
			Admin admin1 = adminService.admin_login(admin);
			System.out.println(admin1);
			
		}
}

