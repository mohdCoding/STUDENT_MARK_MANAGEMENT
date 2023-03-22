package com.application.service;

import java.util.ArrayList;

import com.application.dao.AdminModel;
import com.application.dao.StudentDao;
import com.application.dto.Student;
import com.application.dto.StudentMarks;

public class ServiceImpl implements Service{

	public Boolean check(String email, String password) {
		AdminModel amodel = new AdminModel();
		return amodel.check(email, password);
	}
	
	
	public Student get(Integer rollno) {
		
		StudentDao studentDao = new StudentDao();
		return studentDao.get(rollno);
	}
	
	public ArrayList<StudentMarks> fetch(Integer rollno, String sem) {
		
		StudentDao studentDao = new StudentDao();
		return studentDao.fetch(rollno, sem);
	}
	
	public String update(ArrayList<StudentMarks> studentMarks, String sem) {
		StudentDao studentDao = new StudentDao();
		return studentDao.update(studentMarks, sem);
	}
	
	public ArrayList<StudentMarks> fetch(String sem) {
		StudentDao studentDao = new StudentDao();
		return studentDao.fetch(sem);
	}
	
	public String put(Student student) {
		StudentDao studentDao = new StudentDao();
		return studentDao.put(student);
	}
	
	public String put(Integer rollno, ArrayList<StudentMarks> studentMarks, String sem) {
		StudentDao studentDao = new StudentDao();
		return studentDao.put(rollno, studentMarks, sem);
	}
	
	public String delete(Integer rollno, String sem) {
		StudentDao studentDao = new StudentDao();
		return studentDao.delete(rollno, sem);
	}
	
}
