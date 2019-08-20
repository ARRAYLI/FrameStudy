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
		// 1.加载Hibernate的核心配置文件
		Configuration configuration = new Configuration().configure();
		
		// 2.创建一个SessionFactory对象，类似于JDBC连接池
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3.通过SessionFactory获取到Session对象，类似于JDBC中的Connection
		Session session = sessionFactory.openSession();
		// 4.手动开启事务
		Transaction transaction = session.beginTransaction();
		// 5.编写代码
		Customer customer = new Customer();
		customer.setCust_name("狗狗02");
		session.save(customer);
		// 6.事务提交
		transaction.commit();
		// 7.释放资源
		session.clear();
	}
}
 