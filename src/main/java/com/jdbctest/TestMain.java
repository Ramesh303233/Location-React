package com.jdbctest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMain {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Location loc = new Location();

		loc.setCode("JMS3");
		loc.setName("Jamesdpur3");
		loc.setType("URBAN");

		System.out.println("Loc=::::::::"+loc);
		
		session.save(loc);

		//session.evict(loc);
		
		session.close();

	}

}
