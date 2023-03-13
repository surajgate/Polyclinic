package com.met.iit.cdac.polyclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.met.iit.cdac.polyclinic.dao.PatientDao;
import com.met.iit.cdac.polyclinic.model.Patient;

@Service
public class PatientService {

	@Autowired
	private PatientDao dao;
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void save(Patient patient) {
		
		if(patient.getPatient_id() < 0) {
			
			throw new RuntimeException("ID cannot be less than 1");
		}
		
		dao.save(patient);
		
		System.out.println("Patient DAO Class :" + dao.getClass());
	}
	
	public Collection<Patient> getAllPatients() {
		
		return dao.getAllPatients();
	}
	
	public Patient getPatient(int id) {
		
		return dao.getPatient(id);
	}
	
}
