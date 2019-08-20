package com.itheima.hibernate.demo1;

import static org.junit.Assert.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateDemo01 {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void demo1(){
		// 1.����Hibernate�ĺ��������ļ�
		Configuration configuration = new Configuration().configure();
		
		// 2.����һ��SessionFactory����������JDBC���ӳ�
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3.ͨ��SessionFactory��ȡ��Session����������JDBC�е�Connection
		Session session = sessionFactory.openSession();
		// 4.�ֶ���������
		Transaction transaction = session.beginTransaction();
		// 5.��д����
		Customer customer = new Customer();
		customer.setCust_name("����02");
		session.save(customer);
		// 6.�����ύ
		transaction.commit();
		// 7.�ͷ���Դ
		session.clear();
	}
}
 