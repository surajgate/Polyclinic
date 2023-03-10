package com.met.iit.cdac.polyclinic.model;

public class Dlogin {

	private String email;
	private String password;
	
	
	public Dlogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dlogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DLogin [email=" + email + ", password=" + password + "]";
	}
	
	
}
