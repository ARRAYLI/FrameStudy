package com.itheima.hibernate.demo1;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.hibernate.utils.HibernateUtils;

// 证明以及缓存的存在
public class HibernateDemo02 {
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		/*
		Customer customer1 = session.get(Customer.class, 1l);	// 发送SQL语句
		System.out.println(customer1);
		
		Customer customer2 = session.get(Customer.class, 1l);	// 不发送SQL语句
		System.out.println(customer2);
		
		System.out.println(customer1==customer2);*/
		
		
		Customer customer = new Customer();
		customer.setCust_name("冯佳");
		Serializable id = session.save(customer);
		
		Customer customer2 = session.get(Customer.class, id);  // 不发送SQL语句
		System.out.println(customer2);
		
		tx.commit();
		session.close();
	}
}
 