package com.pagination;

import org.hibernate.query.*;

import com.hibernatedemo.Student1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HqlPagination {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		Query query = s.createQuery("from Student1");
		
		query.setFirstResult(2);
		query.setMaxResults(2);
		
		List<Student1> list = query.list();
		for(Student1 std : list) {
			System.out.println(std.getSid()+" : "+std.getSname()+" : "+std.getCerti().getCourse()+" : "+std.getCerti().getDuration());
		}
		
		s.close();
		factory.close();
		
	}

}
