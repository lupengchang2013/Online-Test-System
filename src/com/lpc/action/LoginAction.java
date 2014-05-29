package com.sanqing.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Student;
import com.sanqing.service.StudentService;
import com.sanqing.service.StudentServiceImpl;
import com.sanqing.service.TeacherService;
import com.sanqing.service.TeacherServiceImpl;

public class LoginAction extends ActionSupport {
	private String id; 			//user id
	private String password;	// user password
	private String role;		// user role
	private StudentService studentService = 
		new StudentServiceImpl();//student serveice
	private TeacherService teacherService = 
		new TeacherServiceImpl();//teacher serveice

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String execute() throws Exception {
		if("student".equals(role)) {
			//if the user login as a student
			if(studentService.allowLogin(id, password)) {
				Student studentInfo = studentService.getStudentInfo(id);
				//record the login info in the session
				Map session = ActionContext.getContext().getSession();
				session.put("studentInfo", studentInfo);
				return "studentSuccess";
			}else {
				addActionError("Invalide password or student ID!");
				return this.INPUT;
			}
		}else {
			if(teacherService.allowLogin(id, password)) {
				return "teacherSuccess";
			}else {
				addActionError("Invalide password or teacher ID");
				return this.INPUT;
			}
		}
	}
}
