package com.application.dto;

public class Student {

	private Integer rollno;
	private String name;
	private String dob;
	
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Integer getRollno() {
		return rollno;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDob() {
		return dob;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", dob=" + dob + "]";
	}
	
	
}
