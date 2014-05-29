package com.sanqing.service;

import java.util.List;

import com.sanqing.po.Student;

public interface StudentService {
	//check if the student is legal
	public boolean allowLogin(String studentID,String password);
	//get student info
	public Student getStudentInfo(String studentID);
	//set student grade
	public void setStudentResult(String studentID,int result);
	//find student by name
	public List<Student> getStudentByName(String studentName);
	//find students by class
	public List<Student> getStudentByClass(String sclass);
}
