package com.met.iit.cdac.polyclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Doctor {

	
	private int doctor_id;
	private String doctor_name;
	private int doctor_age;
	private String qualification;
	private String specialization;
	private int experience;
	private String email;
	private String password;
	private String confirm_password;
	private String time_slot;
	
	public int getDoctor_id() {
		return doctor_id;
	}
	
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	
	public String getDoctor_name() {
		return doctor_name;
	}
	
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public int getDoctor_age() {
		return doctor_age;
	}

	public void setDoctor_age(int doctor_age) {
		this.doctor_age = doctor_age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
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

	public String getTime_slot() {
		return time_slot;
	}

	public void setTime_slot(String time_slot) {
		this.time_slot = time_slot;
	}

	@Override
	public String toString() {
		return "Doctor [doctor_id=" + doctor_id + ", doctor_name=" + doctor_name + ", doctor_age=" + doctor_age
				+ ", qualification=" + qualification + ", specialization=" + specialization + ", experience="
				+ experience + ", email=" + email + ", password=" + password + ", confirm_password=" + confirm_password
				+ ", time_slot=" + time_slot + "]";
	}
	
	
}
