package com.met.iit.cdac.polyclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//@SpringBootApplication (exclude = {SecurityAutoConfiguration.class })

@SpringBootApplication 
public class PolyclinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolyclinicApplication.class, args);
	}

}
