package com.hqldemo;


import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernatedemo.Student1;


public class HqlExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		String query = "from Student1";
		 
		Query q1 = s.createQuery(query);
//		q1.setParameter("x", "Mayuri");
//		q1.setParameter("n",444);

		//single object = q1.uniqueResult();
		//multiple object = list()..method
		List<Student1> std = q1.list();
		for(Student1 student : std) {
			System.out.println(student.getSname()+" : "+ student.getCerti().getCourse());
		}
		System.out.println("_________________________________________________________________");
		
		Transaction tx = s.beginTransaction();
//		Query q2 = s.createQuery("delete from Student1 where sname =: e");
//		q2.setParameter("e", "Bhumesh");
//		int r = q2.executeUpdate();
//		System.out.println("deleted...: ");
//		System.out.println(r);
		
		Query q2 = s.createQuery("update Student1 set duration =:a where sname =: q");
		q2.setParameter("a", "6 months");
		q2.setParameter("q","Akshay");
		
		int r = q2.executeUpdate();
		System.out.println("Updated...");
		System.out.println(r);
		tx.commit();
		//Execute join query...
		Query q3 = s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answer as a");
		List<Object[] >  list3 = q3.getResultList();
		for(Object[] arr : list3) {
			System.out.println(Arrays.toString(arr));
		}
		s.close();
		
		factory.close();
	}

}
