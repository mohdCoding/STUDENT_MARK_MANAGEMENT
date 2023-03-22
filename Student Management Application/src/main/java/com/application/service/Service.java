package com.application.service;

import java.util.ArrayList;

import com.application.dto.Student;
import com.application.dto.StudentMarks;

public interface Service {

	public Boolean check(String email, String password);
	
	public Student get(Integer rollno);
	
	public ArrayList<StudentMarks> fetch(Integer rollno, String sem);
	
	public ArrayList<StudentMarks> fetch(String sem);
		
	public String update(ArrayList<StudentMarks> studentMarks, String sem);
	
	public String put(Student student);
	
	public String put(Integer rollno, ArrayList<StudentMarks> studentMarks, String sem);
	
	public String delete(Integer rollno, String sem);
}
