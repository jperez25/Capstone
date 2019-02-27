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
public class ConditionsDAO extends JdbcDaoSupport {

    @Autowired
    public ConditionsDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
}
