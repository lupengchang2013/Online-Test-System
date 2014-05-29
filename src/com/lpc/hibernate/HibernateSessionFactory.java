package com.sanqing.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static String CONFIG_FILE_LOCATION 
					= "/hibernate.cfg.xml";					//configuration file path
	private static final ThreadLocal<Session> threadLocal 
					= new ThreadLocal<Session>();			//define ThreadLocal object
	private  static Configuration configuration 
					= new Configuration();					//define Configuration object
	private static org.hibernate.SessionFactory sessionFactory;//define SessionFactory object
	private static String configFile = CONFIG_FILE_LOCATION;
	static {
		try {
			configuration.configure(configFile);//read configuration file
			sessionFactory = 
				configuration.buildSessionFactory();//create SessionFactory
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}
	private HibernateSessionFactory() {
	}
	public static Session getSession() throws HibernateException {
		Session session = (Session) threadLocal.get();//get session from ThreadLocal
		if (session == null || !session.isOpen()) {// check if the Session is null
			if (sessionFactory == null) {//if SessionFactory is null, then create it
				rebuildSessionFactory();
			}
			//otherwise open session
			session = (sessionFactory != null) ? sessionFactory.openSession(): null;
			threadLocal.set(session);//save session object in threadLocal
		}
		return session;
	}
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);//read configuration file
			sessionFactory = 
				configuration.buildSessionFactory();//create sessionFactory
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}
	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);//remove session from threadLocal
		if (session != null) {
			session.close();
		}
	}
	public static org.hibernate.SessionFactory getSessionFactory() {//get SessionFactory
		return sessionFactory;
	}
	public static void setConfigFile(String configFile) {//set new configuration file
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}
	public static Configuration getConfiguration() {//get configuration
		return configuration;
	}
}