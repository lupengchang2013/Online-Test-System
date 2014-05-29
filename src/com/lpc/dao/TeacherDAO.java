package com.sanqing.dao;

import com.sanqing.po.Teacher;

public interface TeacherDAO {
	public Teacher findByTeacherID(String teacherID);//find teacher by id
}
