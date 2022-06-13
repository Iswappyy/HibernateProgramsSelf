package com.hibernatedemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println( "Project started..." );
//      SessionFactory factory = new Configuration().configure().buildSessionFactory();
      Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg.xml"); 
      SessionFactory factory = cfg.buildSessionFactory();
      
      Student st = new Student();
      st.setId(111);
      st.setName("Swapnil");
      st.setCity("Pune");
      
      //Creating Object of Address;
      
      Address ad =  new Address();
      ad.setStreet("Kathora Naka");
      ad.setCity("Amravati");
      ad.setOpen(true);
      ad.setAddedDate(new Date());
      ad.setX(1122.33);
      
      //image uploading
      
      FileInputStream fis = new FileInputStream("src/main/java/pic.png");
      byte[] data = new byte[fis.available()];
      fis.read(data);
      ad.setImage(data);
      
      
      Session session = factory.openSession();
      
      session.beginTransaction();
      
      session.save(st);
      session.save(ad);
      
      session.getTransaction().commit();
     
      session.close();
      System.out.println("Done...");
//      System.out.println(factory);
//      System.out.println(factory.isClosed());
  }
}