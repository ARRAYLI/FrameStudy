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
 *	Hibernate �Ĺ��߲�����
 */
public class HibernateDemo02 {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
/*	@Test
	// ����ͻ�
	public void save(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("¡����");	
		Serializable id = session.save(customer);
		System.out.println(id);
		tx.commit();
		session.close();
	}*/
	
	@Test
	// ��ѯ����
	public void demo02(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/*
		 * get����
		 * 		* ���õ����������أ�ִ�е��ⲽ�����ʱ�򣬾ͻ����Ϸ���SQL���ȥ��ѯ��
		 * 		* ��ѯ�󷵻ص�����ʵ������
		 * 		* ��ѯһ���Ҳ����Ķ��󷵻�null
		 * 
		 * 
		 * load ����
		 * 		* ���õ����ӳټ���(lazy����)��ִ�е����д����ʱ�򣬲��ᷢ��SQL��䣬������ʹ����������ʱ��
		 * 			�Żᷢ��SQL���
		 * 		* ��ѯ�󷵻ص��Ǵ������javassist-3.18.1-GA.jar ����javassist���������Ĵ���
		 * 		* ��ѯһ���Ҳ����Ķ���󣬷���
		 * */
		
		
	 /*  // ʹ��get�������в�ѯ
	 	Customer customer = session.get(Customer.class, 100l);			
		System.out.println(customer);*/
	
		// ʹ��load������ѯ
		Customer customer = session.load(Customer.class,10l);
		System.out.println(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// �޸Ĳ���
	public void demo03(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// ֱ�Ӵ������󣬽����޸�
	/*	Customer customer = new Customer();
		customer.setCust_id(1l);
		customer.setCust_name("С��");
		session.update(customer);*/
		
		
		// �Ȳ�ѯ�����޸�
		Customer customer = session.get(Customer.class, 1l);
		customer.setCust_name("��С��");
		session.update(customer);
		tx.commit();
		session.close();
		
	}
	
	@Test
	// ɾ������
	public void demo04(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// ֱ�Ӵ�������ɾ��
		/*Customer customer = new Customer();
		customer.setCust_id(1l);
		session.delete(customer);*/
		
		// �Ȳ�ѯ��ɾ�����Ƽ���---����ɾ��
		Customer customer = session.get(Customer.class, 2l);
		session.delete(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// ������߸��²���
	public void demo05(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/*Customer customer = new Customer();
		customer.setCust_name("����");
		session.saveOrUpdate(customer);*/
		
		Customer customer = new Customer();
		customer.setCust_id(3l);
		customer.setCust_name("���绨");
		session.saveOrUpdate(customer);
		
		tx.commit();
		session.close();
		
	}
	
	@Test
	// ��ѯ����
	public void demo06(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		// ����HQL��Hibernate Query Language ��������ѯ����
		/*Query createQuery = session.createQuery("from Customer");
		List<Customer>list = createQuery.list();
		for(Customer c:list){
			System.out.println(c);
		}*/
		
		// ����SQL��
		SQLQuery createSQLQuery = session.createSQLQuery("select* from cst_customer");
		List<Object[]> list = createSQLQuery.list();
		for(Object []objects:list){
			System.out.println(Arrays.toString(objects));
		}
		
		tx.commit();
		session.close();
	}
	
}
 