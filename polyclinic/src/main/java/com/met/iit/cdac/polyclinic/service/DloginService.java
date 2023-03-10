package com.met.iit.cdac.polyclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.met.iit.cdac.polyclinic.dao.DloginDao;
import com.met.iit.cdac.polyclinic.dao.DoctorDao;
import com.met.iit.cdac.polyclinic.model.Dlogin;
import com.met.iit.cdac.polyclinic.model.Doctor;

@Service
public class DloginService {

	@Autowired
	private DoctorDao dDao;
	
	@Autowired 
	private DloginDao dloginDao;
	

	
	public Doctor getDlogin(Dlogin doctor) {
		
		Doctor Doc = dDao.getDoctor(doctor.getEmail());
		System.out.println("In Service");
		if(Doc!=null)
			System.out.println(Doc);
		return Doc;
				
	}
 public Dlogin getDlogin(String email) {
	 return dloginDao.getDlogin(email);
 }
}
