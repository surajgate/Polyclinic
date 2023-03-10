package com.met.iit.cdac.polyclinic.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
//	appointment_number, patient_id, doctor_id, date_of_appointment, time_of_appointment
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int appointment_number;
	private int patient_id;
	private int doctor_id;
	private Date date_of_appointment;
	private String time_of_appointment;
	
	public int getAppointment_number() {
		return appointment_number;
	}
	public void setAppointment_number(int appointment_number) {
		this.appointment_number = appointment_number;
	}
	
	

	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public Date getDate_of_appointment() {
		return date_of_appointment;
	}
	public void setDate_of_appointment(Date date_of_appointment) {
		this.date_of_appointment = date_of_appointment;
	}
	public String getTime_of_appointment() {
		return time_of_appointment;
	}
	public void setTime_of_appointment(String time_of_appointment) {
		this.time_of_appointment = time_of_appointment;
	}
	
	@Override
	public String toString() {
		return "Appointment [appointment_number=" + appointment_number + ", patient_id=" + patient_id + ", doctor_id="
				+ doctor_id + ", date_of_appointment=" + date_of_appointment + ", time_of_appointment="
				+ time_of_appointment + "]";
	}
	
	
}
