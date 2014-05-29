package com.sanqing.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Subject;
import com.sanqing.service.SubjectService;
import com.sanqing.service.SubjectServiceImpl;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public class QuerySubjectAction extends ActionSupport {
	private int currentPage;
	private SubjectService subjectService = new SubjectServiceImpl();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String execute() throws Exception {
		Page page = new Page();
		page.setEveryPage(10);//every page contains 10 record
		page.setCurrentPage(currentPage);//set current page
		PageResult pageResult = subjectService.querySubjectByPage(page);
		List<Subject> subjects = pageResult.getList();//get the subject record
		page = pageResult.getPage();//get current page
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", subjects);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}
