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

import com.met.iit.cdac.polyclinic.model.Patient;
import com.met.iit.cdac.polyclinic.service.PatientService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value = "allPatients", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Patient>> getAllPatients(){
		
		Collection<Patient> allPatients = patientService.getAllPatients();
		
		return new ResponseEntity<Collection<Patient>>(allPatients, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "getPatient/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Patient> getPatient(@PathVariable int id ){
		
		Patient patient = patientService.getPatient(id);
		
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@PutMapping(value = "updatePatient", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
	
		return null;
	}
	
	@DeleteMapping(value = "deletePatient/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Patient> deletePatient(@PathVariable int id){
		
		return null;
	}
	
	@PostMapping
	@RequestMapping(value = "savePatient", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		patientService.save(patient);
		
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		
	}
}
