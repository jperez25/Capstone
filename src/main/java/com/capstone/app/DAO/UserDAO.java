package com.capstone.app.DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.app.Mapper.UserMapper;
import com.capstone.app.Model.User;


@Repository
@Transactional
public class UserDAO extends JdbcDaoSupport {
 
    @Autowired
    public UserDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    public User findUserAccount(String userName) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = UserMapper.BASE_SQL + " where u.userId = ? ";
 
        Object[] params = new Object[] { userName };
        UserMapper mapper = new UserMapper(); 
        try {
            User userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
 
}
