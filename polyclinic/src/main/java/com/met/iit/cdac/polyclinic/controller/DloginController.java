package com.met.iit.cdac.polyclinic.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.met.iit.cdac.polyclinic.model.Dlogin;
import com.met.iit.cdac.polyclinic.model.Doctor;
import com.met.iit.cdac.polyclinic.service.DloginService;
import com.met.iit.cdac.polyclinic.service.DoctorService;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class DloginController {

	@Autowired
	private DloginService dloginService;

	@RequestMapping(value = "getDlogin/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dlogin> getDoctor(@PathVariable String email) {
		System.out.println(email);
		Dlogin dlogin = dloginService.getDlogin(email);
		
		return new ResponseEntity<Dlogin>(dlogin, HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping(value = "logintest", consumes = "application/json", produces = "application/json")
	public String testLogin(@RequestBody Dlogin test) {

//		System.out.println(test);

		Doctor Doc = dloginService.getDlogin(test);
//		System.out.println("In Controller");
//		System.out.println(Doc);
//		System.out.println(Doc.getPassword() + "==========" + test.getPassword());
		if (Doc != null)
			if (Doc.getPassword().equals(test.getPassword())) {
				System.out.println("in if");
				return "Authentication Successful";
			} else
				System.out.println("in else");
		return "0";

	}

}
