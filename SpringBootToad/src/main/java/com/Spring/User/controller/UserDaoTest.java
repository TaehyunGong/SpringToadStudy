package com.Spring.User.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.Random;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.Spring.User.dao.UserDao;
import com.Spring.User.vo.User;

public class UserDaoTest {

	@Test
	public void addAndGet() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao userdao = context.getBean("userDao", UserDao.class);
		
		userdao.deleteAll();	//모든 row 삭제
		assertThat(userdao.getCount(), is(0)); // 모든 row 갯수가 0인지 확인
		
		User user = new User("UNIQUE_ID", "test", "springTest");
		
		userdao.add(user);	//user Insert
		assertThat(userdao.getCount(), is(1)); //  1 user만 insert 했을테니 row가 1인지 비교
		
		User user2 = new User();
		user2 = userdao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
		
		
	}
	
	@Test
	public void count() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao userdao = context.getBean("userDao", UserDao.class);
		
		User user1 = new User("UNIQUE_ID1", "test1", "springTest1");
		User user2 = new User("UNIQUE_ID2", "test2", "springTest2");
		User user3 = new User("UNIQUE_ID3", "test3", "springTest3");

		userdao.deleteAll();	//모든 row 삭제
		assertThat(userdao.getCount(), is(0)); 
		
		userdao.add(user1);	
		assertThat(userdao.getCount(), is(1)); 

		userdao.add(user2);	
		assertThat(userdao.getCount(), is(2)); 
		
		userdao.add(user3);	
		assertThat(userdao.getCount(), is(3)); 
	}
	
}
