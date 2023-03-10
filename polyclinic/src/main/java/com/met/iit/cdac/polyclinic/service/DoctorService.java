package com.met.iit.cdac.polyclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.met.iit.cdac.polyclinic.dao.DoctorDao;
import com.met.iit.cdac.polyclinic.model.Doctor;

@Service
public class DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void save(Doctor doctor) {
		
		if(doctor.getDoctor_id() < 0) {
			throw new RuntimeException("Doctor ID cannot be less than 0");
		}
		
		doctorDao.save(doctor);
	
		System.out.println("Doctor DAO class :" + doctor.getClass());
	}
	
	public Collection<Doctor> getAllDoctors(){
		
		return doctorDao.getAllDoctors();
	}
	
	public Doctor getDoctor(int id) {
		
		return doctorDao.getDoctor(id);
	}
	
}
