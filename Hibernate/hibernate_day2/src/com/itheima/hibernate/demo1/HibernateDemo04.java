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
 *	Hibernate������API
 */
public class HibernateDemo04 {
	@Test
	public void demo1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// ͨ��Session���Query �ӿ�
		// �򵥲�ѯ
		//String hql = "from Customer";
		// ������ѯ
		//String hql = "from Customer where cust_name like ?";
		// ���÷�ҳ��ѯ
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		//query.setParameter(0, "��%");
		// ��������
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
		
		// ͨ��Session���Criteria�Ķ���
		/*Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		*/
		
		// ������ѯ
		/*Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.like("cust_name","��%"));*/
		
		// ��ҳ��ѯ
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
 