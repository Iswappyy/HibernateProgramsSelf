package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
//		get and load method
		
		 Configuration cfg = new Configuration();
	      cfg.configure("hibernate.cfg.xml"); 
	      SessionFactory factory = cfg.buildSessionFactory();
	      Session session = factory.openSession();
//	      get student id: 
	    //  Student student=(Student)session.get(Student.class, 111);
//	      Student student=(Student)session.load(Student.class, 111);
//	      
//	      System.out.println(student);
	  
	      Address ad = (Address)session.get(Address.class,1);
	      System.out.println(ad.getStreet()+ " : " + ad.getCity());
	      
	      Address ad1 = (Address)session.get(Address.class,1);
	      System.out.println(ad1.getStreet()+ " : " + ad1.getCity());
	      
	      session.close();
	      factory.close();
	}

}
