package com.sqlqueriesdemo;

import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernatedemo.Student1;



public class SqlQueriesDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		//SQL quries
		String q = "select * from Student1";
		
		NativeQuery nq = s.createSQLQuery(q);
		
		List<Object[]> list = nq.list();
		for(Object[] std : list) {
			//System.out.println(Arrays.toString(std));
			System.out.println(std[0]+" : "+std[1]+" : "+ std[2]+ " : "+ std[3]);
			
			//System.out.printf("%d : %s : %s : %s \n",std[0],std[1],std[2],std[3]);
//			Formatter fmt = new Formatter(); 
//			fmt.format("%15s %15s %15s %15s\n","ID","COURSE","DURATION","NAME");
//		
//			
//			fmt.format("%15s %15s %15s %15s\n", std[0],std[1],std[2],std[3]); 
//			System.out.println(fmt);
		}
		s.close();
		factory.close();
	}

}
