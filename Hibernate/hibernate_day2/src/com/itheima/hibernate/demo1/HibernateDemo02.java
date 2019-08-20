package com.itheima.hibernate.demo1;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.hibernate.utils.HibernateUtils;

// ֤���Լ�����Ĵ���
public class HibernateDemo02 {
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		/*
		Customer customer1 = session.get(Customer.class, 1l);	// ����SQL���
		System.out.println(customer1);
		
		Customer customer2 = session.get(Customer.class, 1l);	// ������SQL���
		System.out.println(customer2);
		
		System.out.println(customer1==customer2);*/
		
		
		Customer customer = new Customer();
		customer.setCust_name("���");
		Serializable id = session.save(customer);
		
		Customer customer2 = session.get(Customer.class, id);  // ������SQL���
		System.out.println(customer2);
		
		tx.commit();
		session.close();
	}
}
 