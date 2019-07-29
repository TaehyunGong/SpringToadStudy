package com.Spring.User.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.Spring.User.vo.User;

public class UserDao {
	
	private DataSource dataSource;
	
	public UserDao() {}

	public UserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public void add(User user) throws SQLException{
		Connection c = dataSource.getConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into USERS(id, name, password) values(?,?,?)");
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
				
		ps.executeUpdate();
		
		System.out.println("결과 네임 : " + user.getName());
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws SQLException{
		Connection c = dataSource.getConnection();
		
		PreparedStatement ps = c.prepareStatement("select * from USERS where id = ?");
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getString(1));
		user.setName(rs.getString(2));
		user.setPassword(rs.getString(3));
				
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}


	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


}
