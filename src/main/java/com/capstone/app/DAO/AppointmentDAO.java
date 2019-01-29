package com.capstone.app.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.app.Model.Appointment;

@Repository
@Transactional
public class AppointmentDAO extends JdbcDaoSupport {
	
	@Autowired
    public AppointmentDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
	}
	
	public List<Appointment> getAllApoiments() {
		String sql = "select id, date, hour, duration, description, attendance, diagnostics, first_name, last_name from (" +
								"select appointment.id, date, hour, duration, description, attendance, diagnostics, patient_id, appointment_id, first_name, last_name from " +
								"appointment, patient, appointments_per_patient where appointments_per_patient.appointment_id = appointment.id) as s;";
		   
	   Object[] params = new Object[] {  };
	   
	   List<Appointment> apps = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Appointment>(Appointment.class));

       return apps;
	}
	
	public List<Appointment> getAllApoimentsByPatient(int id) {
		String sql = "select * from appointment,"+
							" (select * from appointments_per_patient where appointments_per_patient.patient_id = ?)"+
							" as app where app.appointment_id = appointment.id;";
		   
	   Object[] params = new Object[] { id };
	   
	   List<Appointment> apps = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Appointment>(Appointment.class));

       return apps;
	}

}
