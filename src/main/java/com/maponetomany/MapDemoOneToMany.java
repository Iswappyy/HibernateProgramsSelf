package com.maponetomany;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MapDemoOneToMany {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//creating Question1 object
		
		Question1 qs = new Question1();
		qs.setQuestionId(1212);
		qs.setQuestion("What is java..?");
		//creating Answer1 Object
		
		Answer1 as = new Answer1();
		as.setAnswerId(343);
		as.setAnswer("Java is Programming language..");
		as.setQuestion(qs);
	
		
		Answer1 as1 = new Answer1();
		as1.setAnswerId(33);
		as1.setAnswer("With the help of java we can create software");
		as1.setQuestion(qs);
		
		Answer1 as2 = new Answer1();
		as2.setAnswerId(363);
		as2.setAnswer("java has different type of framework...");
		as2.setQuestion(qs);
		
		List<Answer1> list  = new ArrayList<Answer1>();
		list.add(as);
		list.add(as1);
		list.add(as2);
		
		
		//session
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(qs);
		s.save(as);
		s.save(as1);
		s.save(as2);
		tx.commit();
		//fetching...
//		Question1 newQ =(Question1)s.get(Question1.class, 1212);
//		System.out.println(newQ.getQuestion());
//        for(Answer1 a : newQ.getAnswer()) {
//        	System.out.println(a.getAnswer());
//        }
		s.close();
		factory.close();
	}

}
