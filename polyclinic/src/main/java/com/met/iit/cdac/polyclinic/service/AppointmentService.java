package com.met.iit.cdac.polyclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.met.iit.cdac.polyclinic.dao.AppointmentDao;
import com.met.iit.cdac.polyclinic.model.Appointment;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentDao appointmentrDao;
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void save(Appointment appointment) {
		
		if(appointment.getAppointment_number() < 0) {
			throw new RuntimeException("Doctor ID cannot be less than 0");
		}
		
		appointmentrDao.save(appointment);
		System.out.println("Appointment DAO class :" + appointment.getClass());
	}
	
	public Collection<Appointment> getAllAppointments(){
		
		return appointmentrDao.getAllAppointments();
	}
	
	public Collection<Appointment> getAppointment(int id) {
		
		return appointmentrDao.getAppointment(id);
	}

}
