package com.capstone.app.DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.app.Model.Insurance;
import com.capstone.app.Model.Patient;

@Repository
@Transactional
public class InsuranceDAO extends JdbcDaoSupport{
	
	@Autowired
    public InsuranceDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
	}
	
	public Insurance getInsuranceById(long id) {
		String sql = "SELECT * FROM capstone.insurance where id = ?; ";
		
		Object[] params = new Object[] { id };
		
		Insurance ins = this.getJdbcTemplate().queryForObject(sql, params, new BeanPropertyRowMapper<Insurance>(Insurance.class));
		
		return ins;
		
	}

	
	public boolean newInsurance(Insurance insurance) {
		String sql = "INSERT INTO insurance(insurance_name, group_number, pcp, effective_date, insurance_number)"+
										" VALUES (?, ?, ?, ?, ? );";
		
		Object[] params = new Object[] { insurance.getInsurance_name(), insurance.getGroup_number(), insurance.getPcp(), insurance.getEffective_date(), insurance.getInsurance_number() };
		
		int rsult = this.getJdbcTemplate().update(sql, params);
		
		if( rsult > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
