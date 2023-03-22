package com.application.dto;

public class StudentMarks {

	private Integer rollno;
	private Integer subjectCode;
	private String subjectName;
	private Integer internal;
	private Integer external;
	private Integer total;
	private String grade;
	private String result;

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	public void setSubjectCode(Integer subjectCode) {
		this.subjectCode = subjectCode;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public void setInternal(Integer internal) {
		this.internal = internal;
	}

	public void setExternal(Integer external) {
		this.external = external;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getRollno() {
		return rollno;
	}

	public Integer getSubjectCode() {
		return subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public Integer getInternal() {
		return internal;
	}

	public Integer getExternal() {
		return external;
	}

	public Integer getTotal() {
		return total;
	}

	public String getGrade() {
		return grade;
	}

	public String getResult() {
		return result;
	}

	public String toString() {
		return "StudentMarks [rollno=" + rollno + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName
				+ ", internal=" + internal + ", external=" + external + ", total=" + total + ", grade=" + grade
				+ ", result=" + result + "]";
	}

}
