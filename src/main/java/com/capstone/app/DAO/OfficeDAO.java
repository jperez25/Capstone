package com.capstone.app.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.app.Mapper.OfficeMapper;
import com.capstone.app.Model.Office;

@Repository
@Transactional
public class OfficeDAO extends JdbcDaoSupport{
	
	@Autowired
    public OfficeDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
	}

	
	public List<Office> getAllOficces(){
	   String sql = "Select * from office";
	   
       Object[] params = new Object[] { "1" };

       List<Office> offices = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Office>(Office.class));

       return offices;
   }
}
