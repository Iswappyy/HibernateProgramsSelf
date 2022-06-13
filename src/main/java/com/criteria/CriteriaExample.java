package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernatedemo.Student1;

public class CriteriaExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Criteria c = session.createCriteria(Student1.class);
		// c.add(Restrictions.eq("certi.course", "Python Language"));
		// c.add(Restrictions.gt("sid", 300));
		// c.add(Restrictions.ilike("certi.course", "c%"));
		// c.addOrder(Order.asc("sname"));
		c.setProjection(Projections.avg("sid"));

		List<Student1> student = c.list();
		
		for (Student1 std : student) {
			System.out.println(std);
		}

		session.close();
		factory.close();

	}

}
