package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.User;


public class UserRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setCust_id(rs.getInt("CUST_ID"));
		user.setCust_name(rs.getString("NAME"));
		user.setAge(rs.getInt("AGE"));
		return user;
	}
}
