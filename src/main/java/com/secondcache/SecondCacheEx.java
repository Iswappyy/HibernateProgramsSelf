package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatedemo.Student1;

public class SecondCacheEx {
	public static void main(String[] args) {

		SessionFactory session = new Configuration().configure().buildSessionFactory();

		Session session1 = session.openSession();

		Student1 student = session1.get(Student1.class, 200);
		System.out.println(student);
		session1.close();

		Session session2 = session.openSession();

		Student1 student2 = session2.get(Student1.class, 200);
		System.out.println(student2);
		session2.close();
	}

}
