package com.capstone.app.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.app.Model.AppointmentsPerPatient;
import com.capstone.app.Model.Patient;

@Repository
@Transactional
public class AppointmetsPerPatientDAO extends JdbcDaoSupport  {
	
	@Autowired
    public AppointmetsPerPatientDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public AppointmentsPerPatient getPatientIdByApptId(long id) {
		
		String sql = "SELECT * FROM capstone.appointments_per_patient where appointment_id = ?;";
		   
	   Object[] params = new Object[] { id };
	   
	   AppointmentsPerPatient apps = this.getJdbcTemplate().queryForObject(sql, params, new BeanPropertyRowMapper<AppointmentsPerPatient>(AppointmentsPerPatient.class));

       return apps;
	}
	

}
