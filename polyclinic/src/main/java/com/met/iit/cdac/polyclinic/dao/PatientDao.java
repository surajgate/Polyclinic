package com.met.iit.cdac.polyclinic.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.met.iit.cdac.polyclinic.model.Patient;

@Repository
public class PatientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(Patient patient) {
		
		jdbcTemplate.update("insert into Patient(patient_id, first_name, last_name, patient_age, blood_group, gender, date_of_birth, phone_number, address, username, email, password, confirm_password) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] {patient.getPatient_id(),patient.getFirst_name(),patient.getLast_name(),patient.getPatient_age(),patient.getBlood_group(),
						patient.getGender(),patient.getDate_of_birth(),patient.getPhone_number(),
				patient.getAddress(),patient.getUsername(),patient.getEmail(),patient.getPassword(),patient.getConfirm_password()}
		);
	}
	
	public Patient getPatient(int id) {
		
		return jdbcTemplate.queryForObject("select * from patient where id=?",
				new Object[] {id}, new BeanPropertyRowMapper<>(Patient.class));
	}
	
	public Collection<Patient> getAllPatients() {
		
		return jdbcTemplate.query("select * from patient",
				new BeanPropertyRowMapper<Patient>(Patient.class));
	}
	
	class PatientMapper implements RowMapper<Patient> {
		
		@Override
		public Patient mapRow(ResultSet rs, int arg1) throws SQLException {
			
			Patient patient = new Patient();
			patient.setPatient_id(rs.getInt("patient_id"));
			patient.setFirst_name(rs.getString("first_name"));
			patient.setLast_name(rs.getString("last_name"));
			patient.setPatient_age(rs.getInt("patient_age"));
			patient.setBlood_group(rs.getString("blood_group"));
			patient.setDate_of_birth(rs.getDate("date_pf_birth"));
			patient.setAddress(rs.getString("address"));
			patient.setUsername(rs.getString("username"));
			patient.setEmail(rs.getString("email"));
			patient.setPassword(rs.getString("password"));
			patient.setConfirm_password(rs.getString("confirm_password"));
			
			
			return patient;
			
		}
	}
	
}
