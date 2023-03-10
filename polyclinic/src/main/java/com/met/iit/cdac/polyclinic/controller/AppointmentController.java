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

import com.met.iit.cdac.polyclinic.model.Appointment;
import com.met.iit.cdac.polyclinic.model.Doctor;
import com.met.iit.cdac.polyclinic.service.AppointmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@RequestMapping(value = "allAppointment", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Appointment>> getAllAppointments() {

		Collection<Appointment> allAppointments = appointmentService.getAllAppointments();

		return new ResponseEntity<Collection<Appointment>>(allAppointments, HttpStatus.OK);
	}

	@RequestMapping(value = "allAppointment/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	
	public ResponseEntity<Collection<Appointment>> getAppointment(@PathVariable int id) {

		Collection<Appointment> appointment = appointmentService.getAppointment(id);

		return new ResponseEntity<Collection<Appointment>>(appointment, HttpStatus.OK);
	}

	@PutMapping(value = "updateAppointment", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {

		return null;
	}

	@DeleteMapping(value = "deleteAppointment/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Appointment> deleteAppointment(@PathVariable int id) {

		return null;
	}

	@PostMapping
	@RequestMapping(value = "saveAppointment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {

		appointmentService.save(appointment);

		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}

}
