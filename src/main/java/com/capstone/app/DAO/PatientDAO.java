package com.capstone.app.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.app.Model.Office;
import com.capstone.app.Model.Patient;

@Repository
@Transactional
public class PatientDAO extends JdbcDaoSupport {

	
	@Autowired
    public PatientDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
	}
	
	public List<Patient> getPatientsByName(String name) {
		String sql = "Select * from patient where last_name like ?";
		   
	   Object[] params = new Object[] { name+"%" };
	   
	   if(name != "") {
		  params = new Object[] { name+"%" };
	   }
	   else{
		   params = new Object[] { name };
	   }
	   
	   List<Patient> patients = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Patient>(Patient.class));

       return patients;
	}
	
	
	public List<Patient> getPatientsByID(String id) {
		String sql = "Select * from patient where id like ?";
		   
	   Object[] params = new Object[] { id+"%" };
	   
	   if(id != "") {
		  params = new Object[] { id+"%" };
	   }
	   else{
		   params = new Object[] { id };
	   }
	   
	   List<Patient> patients = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Patient>(Patient.class));

       return patients;
	}
	
	public Patient getPatientByID(String id) {
		String sql = "Select * from patient where id = ?";
		   
	   Object[] params = new Object[] { id };
	   
	   Patient patient = this.getJdbcTemplate().queryForObject(sql, params, new BeanPropertyRowMapper<Patient>(Patient.class));

       return patient;
	}
	
	public Patient getPatientById(String id) {
		
		String sql = "Select * from patient where id = ?";
		   
		   Object[] params = new Object[] { id };
		   
		   Patient patient = this.getJdbcTemplate().queryForObject(sql, params, new BeanPropertyRowMapper<Patient>(Patient.class));

	       return patient;
		
	}
	
	public boolean newPatient(Patient pat) {
		String sql = "INSERT INTO patient(first_name, last_name, weight, height, eye_colour, ssn, DOB, phone_number, insurance )"+
										" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? );";
		
		Object[] params = new Object[] { pat.getFirst_name(), pat.getLast_name(), pat.getWeight(), pat.getHeight(), 1, pat.getSsn(), pat.getDOB(), pat.getPhone_number(), null };
		
		int rsult = this.getJdbcTemplate().update(sql, params);
		
		if( rsult > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
