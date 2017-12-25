package com.bank.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bank.bean.Client;
import com.bank.bean.Teller;
import com.bank.dao.ClientDao;
import com.bank.dao.TellerDao;
import com.bank.service.TellerService;
import com.bank.service.impl.TellerServiceImpl;

/*	1.导入Spring test测试模块就可以使用Spring的单元测试，自动注入我们的模块
 *  2.@ContextConfiguration指定Spring配置文件的位置
 *  3.直接a'u
 * 
 * */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})

public class MyTest{

	@Autowired
	TellerDao tdao;
	
	@Autowired
	ClientDao cdao;
	
	@Autowired
	private TellerService tellerService;
	
	
	@Test
	public void test() {
	/*	Teller teller = new Teller();
		teller.setTeller_id("1");
		teller.setTeller_ps("1");*/
		String name="1";
		String ps = "1";
		Teller teller1 = tdao.selectByNameAndPassword(name,ps);
		System.out.println(teller1);
		/*List<Teller> teller = tdao.selectAllTellers();
		for (Teller teller2 : teller) {
			System.out.println(teller2);
		}*/
	}
	
	@Test
	public void testMoney() {
		tellerService.transferMoney("client1","client2", 1000d);
	}
	
	@Test
	public void test01() {
		List<Client> clients = cdao.selectAllClients();
		for (Client client : clients) {
			System.out.println(client);
		}
	}
	@Test
	public void test02() {
		Client client = cdao.selectClientById(1);
		System.out.println(client);
	}
	
}