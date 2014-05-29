package com.sanqing.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanqing.hibernate.HibernateSessionFactory;
import com.sanqing.po.Student;
import com.sanqing.po.Subject;
import com.sanqing.util.Page;

public class SubjectDAOImpl implements SubjectDAO{
	public void addSubject(Subject subject){
		Session session = HibernateSessionFactory.getSession();
		Transaction  transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(subject);
			transaction.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	public Subject findSubjectByTitle(String subjectTitle) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle = ?");
		query.setString(0, subjectTitle);
		List list = query.list();					
		HibernateSessionFactory.closeSession();		
		if(list.size() == 0) {
			return null;							
		}else {
			return (Subject) list.get(0);			//return the first result 
		}
	}

	public List<Subject> findSubjectByPage(Page page) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject");
		query.setMaxResults(page.getEveryPage());//set the max number of resut
		query.setFirstResult(page.getBeginIndex());//set the begining of the query
		List list = query.list();					
		HibernateSessionFactory.closeSession();
		return list;
	}

	public int findSubjectCount() {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject");
		List list = query.list();					
		int count = list.size();
		HibernateSessionFactory.closeSession();
		return count;
	}

	public Subject findSubjectByID(int subjectID) {
		Session session = HibernateSessionFactory.getSession();
		Subject subject = (Subject) session.get(Subject.class, subjectID);
		HibernateSessionFactory.closeSession();		
		return subject;
	}

	public void updateSubject(Subject subject) {
		Session session = HibernateSessionFactory.getSession();
		Transaction  transaction = null;
		try{
			transaction = session.beginTransaction();
			session.update(subject);//update subject
			transaction.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	public void deleteSubject(int subjectID) {
		Session session = HibernateSessionFactory.getSession();
		Subject subject = (Subject) session.get(Subject.class, subjectID);
		Transaction  transaction = null;
		try{
			transaction = session.beginTransaction();
			session.delete(subject);
			transaction.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	public List<Subject> likeQueryByTitle(String subjectTitle,Page page) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle like :title ");
		query.setString("title","%"+subjectTitle+"%");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		List list = query.list();					
		HibernateSessionFactory.closeSession();
		return list;
	}

	public int findLinkQueryCount(String subjectTitle) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle like :title ");
		query.setString("title","%"+subjectTitle+"%");
		List list = query.list();					
		int count = list.size();
		HibernateSessionFactory.closeSession();
		return count;
	}

	public List<Subject> randomFindSubject(int number) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub order by rand()");
		query.setMaxResults(number);
		List list = query.list();					
		HibernateSessionFactory.closeSession();
		return list;
	}
}
