package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.maponetomany.Answer1;
import com.maponetomany.Question1;

public class CascadeExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		Question1 q1 = new Question1();
		
		q1.setQuestionId(700);
		q1.setQuestion("What is python?");
		
		Answer1 a1 = new Answer1(44,"python is simple Language..",q1);
		Answer1 a2 = new Answer1(55,"python is not object oriented Language..",q1);
		Answer1 a3 = new Answer1(66,"python is not rhobust Language..",q1);
		List<Answer1> list = new ArrayList();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswer(list);
		Transaction tx = s.beginTransaction();
		
		s.save(q1);
//		s.save(a1);
//		s.save(a2);
//		s.save(a3);
		
		
		tx.commit();
		//s.save(q1);
		s.close();
		factory.close();
	}

}
