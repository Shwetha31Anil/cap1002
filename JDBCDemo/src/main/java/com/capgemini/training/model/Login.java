package com.capgemini.training.model;

import java.util.Date;

public class Login {
	
	private int lid;
	private String email;
	private String pass;
	private String role;
	private Date doc;
	public int getLid() {
		return lid;
	}
	public void setLid(int uid) {
		this.lid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getDoc() {
		return doc;
	}
	public void setDoc(Date doc) {
		this.doc = doc;
	}
	
	

}
