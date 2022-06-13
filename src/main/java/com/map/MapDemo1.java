package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo1 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//creating question object
		
		Question qs = new Question();
		qs.setQuestionId(1212);
		qs.setQuestion("What is java..?");
		//creating Answer Object
		
		Answer as = new Answer();
		as.setAnswerId(343);
		as.setAnswer("Java is Programming language..");
		
		qs.setAnswer(as);
		
		Question qs1 = new Question();
		qs1.setQuestionId(242);
		qs1.setQuestion("What is collection framework..?");
		//creating Answer Object
		
		Answer as1 = new Answer();
		as1.setAnswerId(344);
		as1.setAnswer("API to work with object in java...");
		
		qs1.setAnswer(as1);
		
		
		//session
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(qs);
		s.save(qs1);
		s.save(as);
		s.save(as1);
		tx.commit();
		//fetching...
		Question newQ =(Question)s.get(Question.class, 242);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());
		s.close();
		factory.close();
	}

}
