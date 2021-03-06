package com.sanqing.service;

import com.sanqing.dao.TeacherDAO;
import com.sanqing.dao.TeacherDAOImpl;
import com.sanqing.po.Teacher;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDAO teacherDAO = new TeacherDAOImpl();
	
	public boolean allowLogin(String teacherID, String password) {
		Teacher teacher = teacherDAO.findByTeacherID(teacherID);
		if(teacher == null) {
			return false;
		}else {
			if(password.equals(teacher.getPassword())) {
				return true;
			}else{
				return false;
			}
		}
	}
}
