package com.itheima.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.hibernate.utils.HibernateUtils;

/**
 * Hibernate的主键生成策略
 * @author lzj13
 *
 */
public class HibernateDemo01 {
	@Test
	/*
	 * 保存一条记录
	 */
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("王喜");
		session.save(customer);
		tx.commit();
		session.close();
		
	}
	
	public static void main(String args[]){
	/*	Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("王喜");
		session.save(customer);
		tx.commit();
		session.close();*/
		
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("隆继综");	
	
		tx.commit();
		session.close();
	}
}
 