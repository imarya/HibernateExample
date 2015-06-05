package main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

	private static SessionUtil sessionUtil = new SessionUtil();
	private static SessionFactory sessionFactory;

	private SessionUtil() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		sessionFactory = configuration.buildSessionFactory();
	}

	public static SessionFactory getInstance() {
		return sessionUtil.getSessionFactory();
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
