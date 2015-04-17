package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dto.Student;

public class StoreData {
	public static void main(String[] args) {

		// creating configuration object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// populates the data of the
											// configuration file

		// creating seession factory object
		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object
		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();

		Student s1 = new Student();
		s1.setId(69);
		s1.setFirstName("pradeep");
		s1.setLastName("arya");

		session.persist(s1);// persisting the object

		t.commit();// transaction is commited
		session.close();

		System.out.println("successfully saved");

	}
}
