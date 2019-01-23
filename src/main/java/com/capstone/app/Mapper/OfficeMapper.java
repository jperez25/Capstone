package com.capstone.app.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capstone.app.Model.Office;
import com.capstone.app.Model.User;

public class OfficeMapper implements RowMapper<Office> {

	
	@Override
	public Office mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String location = rs.getString("location");
		
		return new Office(id, name, location);
	}
}
