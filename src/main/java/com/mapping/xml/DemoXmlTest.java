package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DemoXmlTest {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Person person = new Person(77, "Swapnil", "K.P.Pune", "9402343212");
		Person person1 = new Person(88, "Rahul", "Katraj pune", "9973432133");
		Session session = factory.openSession();
		
		Transaction tx  =session.beginTransaction();
		
		session.save(person);
		session.save(person1);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
