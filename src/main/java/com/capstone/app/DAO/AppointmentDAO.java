package com.capstone.app.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.app.Model.Appoiment;
import com.capstone.app.Model.Patient;

@Repository
@Transactional
public class AppoimentDAO extends JdbcDaoSupport {
	
	@Autowired
    public AppoimentDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
	}
	
	public List<Appoiment> getAllApoiments() {
		String sql = "select id, date, hour, duration, description, attendance, diagnostics, first_name, last_name from (" +
								"select appoiment.id, date, hour, duration, description, attendance, diagnostics, patient_id, appoiment_id, first_name, last_name from " +
								"appoiment, patient, appoiments_per_patient where appoiments_per_patient.appoiment_id = appoiment.id) as s;";
		   
	   Object[] params = new Object[] {  };
	   
	   List<Appoiment> apps = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Appoiment>(Appoiment.class));

       return apps;
	}
	
	public List<Appoiment> getAllApoimentsByPatient(int id) {
		String sql = "select * from appoiment,"+
							" (select * from appoiments_per_patient where appoiments_per_patient.patient_id = ?)"+
							" as app where app.appoiment_id = appoiment.id;";
		   
	   Object[] params = new Object[] { id };
	   
	   List<Appoiment> apps = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Appoiment>(Appoiment.class));

       return apps;
	}

}
