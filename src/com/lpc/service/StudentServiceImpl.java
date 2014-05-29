package com.sanqing.service;

import java.util.List;

import com.sanqing.dao.StudentDAO;
import com.sanqing.dao.StudentDAOImpl;
import com.sanqing.po.Student;

public class StudentServiceImpl implements StudentService{
	private StudentDAO studentDAO = new StudentDAOImpl();
	
	public boolean allowLogin(String studentID, String password) {
		
		Student student = studentDAO.findByStudentID(studentID);
		if(student == null) {//check if the student id exists
			return false;
		}else {
			if(password.equals(student.getPassword())) {//check if the password ok
				return true;
			}else{
				return false;
			}
			
		}
	}

	public Student getStudentInfo(String studentID) {
		return studentDAO.findByStudentID(studentID);
	}

	public void setStudentResult(String studentID, int result) {
		Student student = studentDAO.findByStudentID(studentID);//find student by id
		student.setResult(result);//set result
		studentDAO.updateStudent(student);//update student info
	}

	public List<Student> getStudentByName(String studentName) {
		return studentDAO.findByStudentName(studentName);
	}

	public List<Student> getStudentByClass(String sclass) {
		return studentDAO.findByStudentClass(sclass);
	}
}
