package main;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dto.ContactInformation;
import dto.Developer;
import dto.Technology;

public class HibernateTester {

	public static void main(String[] args) {

		SessionFactory sessionFactory = SessionUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Technology technology = new Technology();
		technology.setName("Java");

		Technology technology1 = new Technology();
		technology1.setName("AngularJs");

		ContactInformation contactInformation = new ContactInformation();
		contactInformation.setEmail("impradeeparya@gmail.com");
		contactInformation.setPhoneNumber("+919999710381");

		Developer developer = new Developer();
		developer.setFirstName("Pradeep");
		developer.setLastName("Arya");
		developer.setContactInformation(contactInformation);
		developer.setTechnology(Arrays.asList(technology, technology1));

		session.save(developer);
		tx.commit();
		session.close();

	}

}
