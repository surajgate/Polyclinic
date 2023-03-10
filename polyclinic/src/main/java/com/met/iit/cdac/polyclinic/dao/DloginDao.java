package com.met.iit.cdac.polyclinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.met.iit.cdac.polyclinic.model.Dlogin;
import com.met.iit.cdac.polyclinic.model.Doctor;

@Repository
public class DloginDao {

	private JdbcTemplate jdbcTemplate;
	
public Dlogin getDlogin(String email) {
		
		return jdbcTemplate.queryForObject("select * from doctor where email=?", 
				new Object[] {email}, new BeanPropertyRowMapper<>(Dlogin.class));
  }

class DloginMapper implements RowMapper<Dlogin> {
	
	@Override
	public Dlogin mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Dlogin dlogin = new Dlogin();
		
		dlogin.setEmail(rs.getString("email"));
		dlogin.setPassword(rs.getString("password"));
		
		return dlogin;
	}
  }

}

