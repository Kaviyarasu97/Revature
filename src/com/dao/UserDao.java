package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.User;
import com.util.ConnectionUtil;

public class UserDao {
	
	
	
	
		
		private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
		
		/*public List<User> findAll(){
	
			String sql = "SELECT * FROM User";
			
			List<User> users=new ArrayList<User>();
			List<Map> rows = jdbcTemplate.queryForList(sql);
			for (Map row : rows) {
				Customer customer = new Customer();
				customer.setCustId((Long)(row.get("CUST_ID")));
				customer.setName((String)row.get("NAME"));
				customer.setAge((Integer)row.get("AGE"));
				customers.add(customer);
			}

		
	
			return users;
		}*/
		
		public int findTotalUser(){
	
			String sql = "SELECT COUNT(*) FROM User";
	
			int total = jdbcTemplate.queryForInt(sql);
	
			return total;
		}
		
		public void saveOrUpdate(User User) {
		    if (User.getCust_id() < 0) {
		        // update
		        String sql = "UPDATE User SET cust_id=?, cust_name=?, age=?, "
		                    + " WHERE cust_id=?";
		        jdbcTemplate.update(sql, User.getCust_id(), User.getCust_name(),
		                User.getAge(),User.getCust_id());
		    } else {
		        // insert
	        String sql = "INSERT INTO User (cust_id,cust_name,age)"
		                    + " VALUES (?, ?, ?)";
		        jdbcTemplate.update(sql, User.getCust_id(), User.getCust_name(),
		                User.getAge());
	    }
		 
		}
		
		public void delete(int cust_id) {
		    String sql = "DELETE FROM User WHERE cust_id=?";
		    jdbcTemplate.update(sql, cust_id);
		    
		    System.out.println("Successfully deleted");
		}
		
	
	}


