package com.sanqing.dao;

import java.util.List;

import com.sanqing.po.Subject;
import com.sanqing.util.Page;

public interface SubjectDAO {
	public void addSubject(Subject subject);//add subject
	public Subject findSubjectByTitle(String subjectTitle);//find subject by title
	public List<Subject> findSubjectByPage(Page page);//find subject by page
	public int findSubjectCount();//find the total number of subject
	public Subject findSubjectByID(int subjectID);//find subject by id
	public void updateSubject(Subject subject);//update subject
	public void deleteSubject(int subjectID);//delete subject by id
	public List<Subject> likeQueryByTitle(String subjectTitle,Page page);//find subject by using keyword in title
	public int findLinkQueryCount(String subjectTitle);//find number of relative sumbject by using keyword in title
	public List<Subject> randomFindSubject(int number);//random find subject
}
