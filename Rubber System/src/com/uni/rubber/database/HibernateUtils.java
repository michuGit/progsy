package com.uni.rubber.database;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.uni.rubber.tables.BomHeader;
import com.uni.rubber.tables.Table;

public class HibernateUtils {
	private static SessionFactory factory;

	public static void connect() {
		try {
			Configuration cfg = new Configuration();
			factory = cfg.configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static List<Table> select(String query) {
		Session session = factory.openSession();
		Transaction transaction = null;
		List<Table> table = null;
		try {
			transaction = session.beginTransaction();
			table = session.createQuery(query).list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return table;
	}
}
