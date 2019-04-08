package com.capstone.app.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.app.Model.Emergency_contacts;

@Repository
@Transactional
public class EmergencyContactDAO extends JdbcDaoSupport {
	
	@Autowired
    public EmergencyContactDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
	}
	
	public List<Emergency_contacts> get_emer_contact_by_pat_id(int id){
		
		String sql = "SELECT * FROM emergency_contacts where id = ?";
		   
		   Object[] params = new Object[] { id };
		   
		   List<Emergency_contacts> contcs = this.getJdbcTemplate().query(sql, params, new BeanPropertyRowMapper<Emergency_contacts>(Emergency_contacts.class));

	       return contcs;
	}
	
}
