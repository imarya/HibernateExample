package main;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dto.Address;
import dto.Company;
import dto.Developer;
import dto.EmailIdentity;
import dto.Technology;

public class HibernateTester {

	public static void main(String[] args) {

		/* Creating and Saving Data */
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

		EmailIdentity emailId = new EmailIdentity();
		emailId.setEmail("impradeeparya@yahoo.co.in");

		Address address = new Address();
		address.setCountry("India");
		address.setState("New Delhi");
		address.setStreet("Punjabi Bagh");
		address.setHouseNumber("69");

		Company company = new Company();
		company.setName("Samsung R&D");

		/* First Row */
		Developer developer = new Developer();
		developer.setFirstName("Pradeep");
		developer.setLastName("Arya");
		developer.setEmailId(Arrays.asList(emailId));
		developer.setTechnology(Arrays.asList(technology, technology1));
		developer.setAddress(address);
		developer.setCompany(company);

		EmailIdentity emailId1 = new EmailIdentity();
		emailId1.setEmail("impradeeparya@gmail.com");

		Address address1 = new Address();
		address1.setCountry("India");
		address1.setState("Gurgaon");
		address1.setStreet("DLF");
		address1.setHouseNumber("10");

		/* Second Row */
		Developer developer1 = new Developer();
		developer1.setFirstName("Deepu");
		developer1.setLastName("Arya");
		developer1.setEmailId(Arrays.asList(emailId1));
		developer1.setTechnology(Arrays.asList(technology, technology1,
				technology2, technology3));
		developer1.setAddress(address1);
		developer1.setCompany(company);

		session.save(developer);
		session.save(developer1);
		tx.commit();
		session.close();

		/* Removing Data */
		sessionFactory = SessionUtil.getInstance();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Developer developer2 = (Developer) session.get(Developer.class, 2);
		System.out.println("Developer Name : " + developer2.getFirstName());
		session.delete(developer2); // Throws exception foreign key constraint
									// as you cannot delete ManyToMany and
									// ManyToOne Column because they have
									// reference for other column also.
		tx.commit();
		session.close();
	}

}
