package com.itheima.hibernate.demo1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.itheima.hibernate.utils.HibernateUtils;

/**
 * @author lzj13
 *	Hibernate的其他API
 */
public class HibernateDemo04 {
	@Test
	public void demo1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 通过Session获得Query 接口
		// 简单查询
		//String hql = "from Customer";
		// 条件查询
		//String hql = "from Customer where cust_name like ?";
		// 设置分页查询
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		//query.setParameter(0, "王%");
		// 设置条件
		query.setFirstResult(3);
		query.setMaxResults(3);
		
		
		List<Customer> list = query.list();
		
		for(Customer c:list){
			System.out.println(c);
		}
		tx.commit();
	}
	
	@Test
	// Criteria
	public void demo2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 通过Session获得Criteria的对象
		/*Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		*/
		
		// 条件查询
		/*Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.like("cust_name","李%"));*/
		
		// 分页查询
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setFirstResult(3);
		criteria.setMaxResults(3);
		List<Customer> list = criteria.list();
		for(Customer c:list){
			System.out.println(c);
		}
		tx.commit();
	}
}
 