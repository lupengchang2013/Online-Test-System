package com.sanqing.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanqing.hibernate.HibernateSessionFactory;
import com.sanqing.po.Student;
import com.sanqing.po.Subject;

public class StudentDAOImpl implements StudentDAO{
	public Student findByStudentID(String studentID) {
		Session session = HibernateSessionFactory.getSession();//get the session
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();//close the session
		return student;
	}

	public void updateStudent(Student student) {
		Session session = HibernateSessionFactory.getSession();
		Transaction  transaction = null;//declare a transaction
		try{
			transaction = session.beginTransaction();//open transaction
			session.update(student);//update student info
			transaction.commit();//commint transaction
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//transaction roll back
		}
		HibernateSessionFactory.closeSession();
	}

	public List<Student> findByStudentName(String studentName) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student as stu where stu.studentName = ?");
		query.setString(0, studentName);
		List list = query.list();					//save query result into list
		HibernateSessionFactory.closeSession();	
		return list;
	}

	public List<Student> findByStudentClass(String sclass) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student as stu where stu.sclass = ?");
		query.setString(0, sclass);
		List list = query.list();				
		HibernateSessionFactory.closeSession();	
		return list;
	}
}
