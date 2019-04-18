package com.capstone.app.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.app.Model.Appointment;

@Repository
@Transactional
public class AppointmentDAO extends JdbcDaoSupport {
	
	@Autowired
    public AppointmentDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
	}
	
	public List<Appointment> getAllApoiments() {
		/*String sql = "select id, date, hour, duration, description, attendance, diagnostics, first_name, last_name from (" +
								"select appointment.id, date, hour, duration, description, attendance, diagnostics, patient_id, appointment_id, first_name, last_name from " +
								"appointment, patient, appointments_per_patient where appointments_per_patient.appointment_id = appointment.id) as s;";
		*/
		
		String sql = "select * from appointment;";
		   
	   Object[] params = new Object[] {  };
	   
	   List<Appointment> apps = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Appointment>(Appointment.class));

       return apps;
    }
	
	public List<Appointment> getAllTodaysAppointments() {
		
		String sql = "SELECT * FROM appointment where appointment.date = curdate(); ";
		   
	   Object[] params = new Object[] {  };
	   
	   List<Appointment> apps = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Appointment>(Appointment.class));

       return apps;
	}
	
	public List<Appointment> getAllApoimentsByPatient(int id) {
		String sql = "select * from appointment";
		   
	   Object[] params = new Object[] { id };
	   
	   List<Appointment> apps = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Appointment>(Appointment.class));

       return apps;
	}
	
	
	public Appointment getApoimentsById(int id) {
		String sql = "select * from appointment where id = ?";
		   
	   Object[] params = new Object[] { id };
	   
	   Appointment app = this.getJdbcTemplate().queryForObject(sql, params, new BeanPropertyRowMapper<Appointment>(Appointment.class));

       return app;
	}
	
	public void storeAppointment(String date, int start, String duration, String patient, String doctor) {
	    
	    System.out.println(patient);
	    String sql = "INSERT INTO appointment (date, hour, duration, doctor, description, purpose, attendance, diagnostics, patient_id)"
	                  + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    Object[] params = new Object[] {date, start, duration,doctor, patient+doctor,"", 0, "", 0};
	    this.getJdbcTemplate().update(sql, params);  
    
    }
	
	public void updateAppointment(int id, String date, int start, String duration, String description) {
        
        String sql = "UPDATE appointment SET date = ?, hour = ?, duration = ?, description = ?, attendance = ?, diagnostics = ?"
                      + " WHERE appointment.id = ?";
        Object[] params = new Object[] {date, start, duration,description,0, "", id};
        this.getJdbcTemplate().update(sql, params);  
    }
	
	 public void deleteAppointment(int id) {
	        
	      String sql_two = "DELETE FROM appointment WHERE id = ?";
	      Object[] params = new Object[] {id};  
	      this.getJdbcTemplate().update(sql_two, params); 
	    }
	 
	 public Appointment getPatientIdByAppt(long app_id) {
			
			String sql = "SELECT patient_id FROM appointment where id = ?;";
			   
		   Object[] params = new Object[] { app_id };
		   
		   Appointment pat_id = this.getJdbcTemplate().queryForObject(sql, params, new BeanPropertyRowMapper<Appointment>(Appointment.class));

	       return pat_id;
		}
	   
}
