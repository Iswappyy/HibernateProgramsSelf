package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedTest {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student1 st1 = new Student1();
		st1.setSid(100);
		st1.setSname("Swapnil");
		
		Certificate cft = new Certificate();
		
		cft.setCourse("JAVA Language");
		cft.setDuration("6 Months");
		
		st1.setCerti(cft);
		
		Student1 st2 = new Student1();
		st2.setSid(200);
		st2.setSname("Mayuri");
		
		Certificate cft1 = new Certificate();
		
		cft1.setCourse("Python Language");
		cft1.setDuration("3 Months");
		
		st2.setCerti(cft1);
		
		Student1 st3 = new Student1();
		st3.setSid(300);
		st3.setSname("Akshay");
		
		Certificate cft2 = new Certificate();
		
		cft2.setCourse("C Language");
		cft2.setDuration("3 Months");
		
		st3.setCerti(cft2);
		
		Student1 st4 = new Student1();
		st4.setSid(400);
		st4.setSname("Bhumesh");
		
		Certificate cft3 = new Certificate();
		
		cft3.setCourse("Cloud Language");
		cft3.setDuration("9 Months");
		
		st4.setCerti(cft3);
		
		Student1 st5 = new Student1();
		st5.setSid(500);
		st5.setSname("Ajay");
		
		Certificate cft4 = new Certificate();
		
		cft4.setCourse("Swift Language");
		cft4.setDuration("3 Months");
		
		st5.setCerti(cft4);
		
		
		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();
		
		session.save(st1);
		session.save(st2);
		session.save(st3);
		session.save(st4);
		session.save(st5);
		txt.commit();
		session.close();
		
		factory.close();
	}

}
