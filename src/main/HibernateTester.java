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

		Technology technology2 = new Technology();
		technology2.setName("Spring");

		Technology technology3 = new Technology();
		technology3.setName("Hibernate");

		ContactInformation contactInformation = new ContactInformation();
		contactInformation.setEmail("impradeeparya@yahoo.co.in");
		contactInformation.setPhoneNumber("+919999710381");

		Developer developer = new Developer();
		developer.setFirstName("Pradeep");
		developer.setLastName("Arya");
		developer.setContactInformation(contactInformation);
		developer.setTechnology(Arrays.asList(technology, technology1));

		ContactInformation contactInformation1 = new ContactInformation();
		contactInformation1.setEmail("impradeeparya@gmail.com");
		contactInformation1.setPhoneNumber("+919999710381");
		
		Developer developer1 = new Developer();
		developer1.setFirstName("Deepu");
		developer1.setLastName("Arya");
		// developer1.setContactInformation(contactInformation);
		developer1.setContactInformation(contactInformation1);
		developer1.setTechnology(Arrays.asList(technology2, technology3));

		session.save(developer);
		session.save(developer1);
		tx.commit();
		session.close();

	}

}
