package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dto.Developer;
import dto.Technology;

public class HibernateTester {

	public static void main(String[] args) {

		SessionFactory sessionFactory = SessionUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Technology technology = new Technology();
		technology.setName("Java");
		
		Developer developer = new Developer();
		developer.setFirstName("Pradeep");
		developer.setLastName("Arya");
		developer.setTechnology(technology);

		session.save(developer);
		tx.commit();
		session.close();

	}

}
