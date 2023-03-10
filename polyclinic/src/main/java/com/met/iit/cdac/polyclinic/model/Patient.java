package com.met.iit.cdac.polyclinic.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patient_id;
	private String first_name;
	private String last_name;
	private int patient_age;
	private String blood_group;
	private String gender;
	private Date date_of_birth;
	private String phone_number;
	private String address;
	private String username;
	private String email;
	private String password;
	private String confirm_password;
//	private int doctor_id;
	
	public int getPatient_id() {
		return patient_id;
	}
	
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public int getPatient_age() {
		return patient_age;
	}
	
	public void setPatient_age(int patient_age) {
		this.patient_age = patient_age;
	}
	
	public String getBlood_group() {
		return blood_group;
	}
	
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	
	public String getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
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
	
	public String getConfirm_password() {
		return confirm_password;
	}
	
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", patient_age=" + patient_age + ", blood_group=" + blood_group + ", gender=" + gender
				+ ", date_of_birth=" + date_of_birth + ", phone_number=" + phone_number + ", address=" + address
				+ ", username=" + username + ", email=" + email + ", password=" + password + ", confirm_password="
				+ confirm_password + "]";
	}

//	public int getDoctor_id() {
//		return doctor_id;
//	}
//
//	public void setDoctor_id(int doctor_id) {
//		this.doctor_id = doctor_id;
//	}

	
	
	
}
