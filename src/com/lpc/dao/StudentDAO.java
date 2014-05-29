package com.sanqing.dao;

import java.util.List;

import com.sanqing.po.Student;

public interface StudentDAO {
	public Student findByStudentID(String studentID);//find student by id
	public void updateStudent(Student student);//update student info
	public List<Student> findByStudentName(String studentName);//find student by name
	public List<Student> findByStudentClass(String sclass);//find students by class number
}
