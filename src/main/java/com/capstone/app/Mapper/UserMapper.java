package com.capstone.app.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.springframework.jdbc.core.RowMapper;

import com.capstone.app.Model.User;


public class UserMapper  implements RowMapper<User> {
	public static final String BASE_SQL //
    = "Select u.id, u.userId, u.name, u.password, u.office, u.position From users u ";

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	int id = rs.getInt("id");
	String userId = rs.getString("userId");
	String userName = rs.getString("name");
	String encrytedPassword = rs.getString("password");
	String office = rs.getString("office");
	String position = rs.getString("position");
	
	return new User(id, userId, userName, encrytedPassword, office, position);
	}

}
