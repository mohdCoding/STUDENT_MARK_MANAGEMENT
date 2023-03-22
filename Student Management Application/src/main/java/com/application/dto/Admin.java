package com.application.dto;





public class Admin {


	private Integer aid;
	

	private String aname;
	

	private String aemail;
	

	private String apassword;

	public Integer getAid() {
		return aid;
	}

	public String getAname() {
		return aname;
	}

	public String getApassword() {
		return apassword;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemai(String aemail) {
		this.aemail = aemail;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", aemai=" + aemail + ", apassword=" + apassword + "]";
	}

}
