package com.persistentlifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DemoPersistent {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student2 st1 = new Student2();
		st1.setSid(100);
		st1.setSname("Ranvir");
		
		Certificate2 c1 = new Certificate2();
		c1.setCourse("Hibernate frameWork course");
		c1.setDuration("Three Months");
		st1.setCerti(c1);    //Transient State...
		
		Session s = factory.openSession();
		Transaction txt = s.beginTransaction();
		s.save(st1);         //persistent state.....(Object value is with database as well as session object)
		
		txt.commit();
		factory.close();
	}

}
