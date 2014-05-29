package com.sanqing.service;

import java.util.List;

import com.sanqing.po.Subject;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public interface SubjectService {
	// add subject if it's not exists
	public boolean saveSubject(Subject subject);
	// find subjects by page
	public PageResult querySubjectByPage(Page page);
	// show details of the subject
	public Subject showSubjectParticular(int subjectID);
	// update subject info
	public void updateSubject(Subject subject);
	// delete subject
	public void deleteSubject(int subjectID);
	//blur search
	public PageResult likeQueryBySubjectTitle(String subjectTitle,Page page);
	//random find subject
	public List<Subject> randomFindSubject(int number);
	//grade
	public int accountResult(List<Integer> subjectIDs,List<String> studentAnswers);
}
