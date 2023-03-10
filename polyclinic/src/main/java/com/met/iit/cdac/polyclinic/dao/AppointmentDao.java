package com.met.iit.cdac.polyclinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.met.iit.cdac.polyclinic.model.Appointment;

@Repository
public class AppointmentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(Appointment appointment) {
		
		jdbcTemplate.update("insert into appointment values (?, ?, ? ,?, ?)",
				new Object[] {appointment.getAppointment_number(), appointment.getPatient_id(), appointment.getDoctor_id(),
						appointment.getDate_of_appointment(), appointment.getTime_of_appointment()});
		
	}
	
	public Collection<Appointment> getAllAppointments(){
		
		return jdbcTemplate.query("select * from appointment", 
				new BeanPropertyRowMapper<Appointment>(Appointment.class));
	}
	
	public Collection<Appointment> getAppointment(int id) {
		
		return jdbcTemplate.query("select * from appointment where doctor_id=?", 
				new Object[] {id}, new BeanPropertyRowMapper<Appointment>(Appointment.class));
	}
	
	class AppointmentMapper implements RowMapper<Appointment> {

		@Override
		public Appointment mapRow(ResultSet rs, int arg1) throws SQLException {
//			appointment_number, patient_id, doctor_id, date_of_appointment, time_of_appointment
			Appointment appointment = new Appointment();
					
			appointment.setAppointment_number(rs.getInt("appointment_number"));
			appointment.setPatient_id(rs.getInt("patient_id"));
			appointment.setDoctor_id(rs.getInt("doctor_id"));
			appointment.setDate_of_appointment(rs.getDate("date_of_appointment"));
			appointment.setTime_of_appointment(rs.getString("time_of_appointment"));
			return appointment;
		}
	
		
		}
	}

