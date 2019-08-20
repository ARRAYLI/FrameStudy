package com.itheima.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.itheima.hibernate.utils.HibernateUtils;

/**
 * @author lzj13
 *	测试当前线程绑定的Session 
 */
public class HibernateDemo03 {
	@Test
	public void demo1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("王北车");
		session.save(customer);
		
		tx.commit();
		session.close();
	}
	
}
 