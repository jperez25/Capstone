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
	   
	   List<Patient> patients = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Patient>(Patient.class));

       return patients;
		
	}
}
