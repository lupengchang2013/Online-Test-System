package com.sanqing.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Subject;
import com.sanqing.service.SubjectService;
import com.sanqing.service.SubjectServiceImpl;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public class LikeQuerySubjectAction extends ActionSupport {
	private String subjectTitle;	//subject title
	private int currentPage;		//current page of the test
	private SubjectService subjectService = new SubjectServiceImpl();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public String execute() throws Exception {
		Page page = new Page();
		page.setEveryPage(10);//every page contains 10 questions
		page.setCurrentPage(currentPage);//set current page
		PageResult pageResult = subjectService.likeQueryBySubjectTitle(subjectTitle, page);
		List<Subject> subjects = pageResult.getList();//get test record
		List<Subject> newSubjects = new ArrayList<Subject>();//new record
		//highligten the key word
		for(Subject subject : subjects) {
			String newTitle = subject.getSubjectTitle().replaceAll(subjectTitle,
						"<font color='red'>" + subjectTitle + "</font>");
			subject.setSubjectTitle(newTitle);
			newSubjects.add(subject);
		}
		
		page = pageResult.getPage();//get page
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", newSubjects);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}
