package com.met.iit.cdac.polyclinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.met.iit.cdac.polyclinic.model.Doctor;
import com.met.iit.cdac.polyclinic.model.Patient;

@Repository
public class DoctorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Doctor doctor) {

		jdbcTemplate.update("insert into doctor values (?, ?, ? ,?, ?, ?, ?, ?, ?, ?)",
				new Object[] { doctor.getDoctor_id(), doctor.getDoctor_name(), doctor.getDoctor_age(),
						doctor.getQualification(), doctor.getSpecialization(), doctor.getExperience(),
						doctor.getEmail(), doctor.getPassword(), doctor.getConfirm_password(), doctor.getTime_slot() });

	}

	public Collection<Doctor> getAllDoctors() {

		return jdbcTemplate.query("select * from doctor", new BeanPropertyRowMapper<Doctor>(Doctor.class));
	}

	public Doctor getDoctor(int id) {

		return jdbcTemplate.queryForObject("select * from doctor where id=?", new Object[] { id },
				new BeanPropertyRowMapper<>(Doctor.class));
	}

	public Doctor getDoctor(String email) {
		System.out.println("In Dao");
		try {
			Doctor Doc = jdbcTemplate.queryForObject("select * from doctor where email=?", new Object[] { email },
					new BeanPropertyRowMapper<>(Doctor.class));
			System.out.println(Doc);
			return Doc;

		} catch (Exception e) {
			Doctor doc = null;
			return doc;
		}
	}

	class DoctorMapper implements RowMapper<Doctor> {

		@Override
		public Doctor mapRow(ResultSet rs, int arg1) throws SQLException {

			Doctor doctor = new Doctor();
			doctor.setDoctor_id(rs.getInt("doctor_id"));
			doctor.setDoctor_name(rs.getString("doctor_name"));
			doctor.setDoctor_age(rs.getInt("doctor_age"));
			doctor.setQualification(rs.getString("qualification"));
			doctor.setSpecialization(rs.getString("specialization"));
			doctor.setExperience(rs.getInt("experience"));
			doctor.setEmail(rs.getString("email"));
			doctor.setPassword(rs.getString("password"));
			doctor.setConfirm_password(rs.getString("confirm_password"));

			return doctor;
		}
	}
}
