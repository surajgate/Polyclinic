package com.met.iit.cdac.polyclinic.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.met.iit.cdac.polyclinic.model.Doctor;
import com.met.iit.cdac.polyclinic.service.DoctorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value = "allDoctors", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Doctor>> getAllDoctors(){
		
		Collection<Doctor> allDoctors = doctorService.getAllDoctors();
		
		return new ResponseEntity<Collection<Doctor>>(allDoctors,HttpStatus.OK);
	}
	
	@RequestMapping(value = "getDoctor/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Doctor> getDoctor(@PathVariable int id){
		
		Doctor doctor = doctorService.getDoctor(id);
		
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	
	@PutMapping(value = "updateDoctor", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor){
		
		return null;
	}
	
	@DeleteMapping(value = "deleteDoctor/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Doctor> deleteEmp(@PathVariable int id){
		
		return null;
	}
	
	@PostMapping
	@RequestMapping(value = "saveDoctor", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		
		doctorService.save(doctor);
		
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
}
