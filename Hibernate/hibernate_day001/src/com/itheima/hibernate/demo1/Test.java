package com.itheima.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		System.out.println("===============1=================");
		// 1.加载Hibernate的核心配置文件
		Configuration configuration = new Configuration().configure();
		//configuration.addResource("com/itheima/hibernate/demo1/Customer.hbm.xml");
		System.out.println("===============2=================");
		// 2.创建一个SessionFactory对象，类似于JDBC连接池
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3.通过SessionFactory获取到Session对象，类似于JDBC中的Connection
		Session session = sessionFactory.openSession();
		
		System.out.println("===============3=================");
		// 4.手动开启事务
		Transaction transaction = session.beginTransaction();
		System.out.println("===============4=================");
		// 5.编写代码
		Customer customer = new Customer();
		customer.setCust_name("王东4");
		System.out.println("===============5=================");
		session.save(customer);
		// 6.事务提交
		transaction.commit();
		// 7.释放资源
		session.clear();
		System.out.println("===============6=================");
	}
}
