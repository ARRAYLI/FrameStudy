package com.itheima.hibernate.demo1;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.hibernate.utils.HibernateUtils;
import com.mchange.v1.db.sql.CBPUtils;


/**
 * @author lzj13
 *	Hibernate 的工具测试类
 */
public class HibernateDemo02 {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
/*	@Test
	// 保存客户
	public void save(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("隆继综");	
		Serializable id = session.save(customer);
		System.out.println(id);
		tx.commit();
		session.close();
	}*/
	
	@Test
	// 查询操作
	public void demo02(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/*
		 * get方法
		 * 		* 采用的是立即加载，执行到这步代码的时候，就会马上发送SQL语句去查询。
		 * 		* 查询后返回的是真实对象本身
		 * 		* 查询一个找不到的对象返回null
		 * 
		 * 
		 * load 方法
		 * 		* 采用的是延迟加载(lazy加载)，执行到这行代码的时候，不会发送SQL语句，当真正使用这个对象的时候
		 * 			才会发送SQL语句
		 * 		* 查询后返回的是代理对象。javassist-3.18.1-GA.jar 利用javassist技术产生的代理。
		 * 		* 查询一个找不到的对象后，返回
		 * */
		
		
	 /*  // 使用get方法进行查询
	 	Customer customer = session.get(Customer.class, 100l);			
		System.out.println(customer);*/
	
		// 使用load方法查询
		Customer customer = session.load(Customer.class,10l);
		System.out.println(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 修改操作
	public void demo03(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// 直接创建对象，进行修改
	/*	Customer customer = new Customer();
		customer.setCust_id(1l);
		customer.setCust_name("小贱");
		session.update(customer);*/
		
		
		// 先查询，后修改
		Customer customer = session.get(Customer.class, 1l);
		customer.setCust_name("王小贱");
		session.update(customer);
		tx.commit();
		session.close();
		
	}
	
	@Test
	// 删除操作
	public void demo04(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// 直接创建对象，删除
		/*Customer customer = new Customer();
		customer.setCust_id(1l);
		session.delete(customer);*/
		
		// 先查询再删除（推荐）---级联删除
		Customer customer = session.get(Customer.class, 2l);
		session.delete(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 保存或者更新操作
	public void demo05(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/*Customer customer = new Customer();
		customer.setCust_name("王风");
		session.saveOrUpdate(customer);*/
		
		Customer customer = new Customer();
		customer.setCust_id(3l);
		customer.setCust_name("利如花");
		session.saveOrUpdate(customer);
		
		tx.commit();
		session.close();
		
	}
	
	@Test
	// 查询所有
	public void demo06(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		// 接收HQL：Hibernate Query Language 面向对象查询语言
		/*Query createQuery = session.createQuery("from Customer");
		List<Customer>list = createQuery.list();
		for(Customer c:list){
			System.out.println(c);
		}*/
		
		// 接收SQL：
		SQLQuery createSQLQuery = session.createSQLQuery("select* from cst_customer");
		List<Object[]> list = createSQLQuery.list();
		for(Object []objects:list){
			System.out.println(Arrays.toString(objects));
		}
		
		tx.commit();
		session.close();
	}
	
}
 