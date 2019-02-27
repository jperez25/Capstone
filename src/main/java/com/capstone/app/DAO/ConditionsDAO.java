package com.capstone.app.DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.app.Model.Conditions;
import com.capstone.app.Model.Insurance;

@Repository
@Transactional
public class ConditionsDAO extends JdbcDaoSupport{
	
	@Autowired
    public ConditionsDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
	}

	
	public boolean newCondition(Conditions condition) {
		String sql = "INSERT INTO conditions(name, description, type)"+
										" VALUES (?, ?, ?);";
		
		Object[] params = new Object[] {  };
		
		int rsult = this.getJdbcTemplate().update(sql, params);
		
		if( rsult > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
