package com.itheima.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		System.out.println("===============1=================");
		// 1.����Hibernate�ĺ��������ļ�
		Configuration configuration = new Configuration().configure();
		//configuration.addResource("com/itheima/hibernate/demo1/Customer.hbm.xml");
		System.out.println("===============2=================");
		// 2.����һ��SessionFactory����������JDBC���ӳ�
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3.ͨ��SessionFactory��ȡ��Session����������JDBC�е�Connection
		Session session = sessionFactory.openSession();
		
		System.out.println("===============3=================");
		// 4.�ֶ���������
		Transaction transaction = session.beginTransaction();
		System.out.println("===============4=================");
		// 5.��д����
		Customer customer = new Customer();
		customer.setCust_name("����4");
		System.out.println("===============5=================");
		session.save(customer);
		// 6.�����ύ
		transaction.commit();
		// 7.�ͷ���Դ
		session.clear();
		System.out.println("===============6=================");
	}
}
