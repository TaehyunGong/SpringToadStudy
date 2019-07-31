package com.Spring.User.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Spring.User.dao.UserDao;
import com.Spring.User.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class UserDaoTest {

	//private ApplicationContext context;
	@Autowired
	UserDao userdao;
	
	private User user1;
	private User user2;
	private User user3;
	
	@Before
	public void setUp() {
		System.out.println("before 객체");
//		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		//this.userdao = context.getBean("userDao", UserDao.class);
		
		this.user1 = new User("UNIQUE_ID1", "test1", "springTest1");
		this.user2 = new User("UNIQUE_ID2", "test2", "springTest2");
		this.user3 = new User("UNIQUE_ID3", "test3", "springTest3");
	}
	
	@Test
	public void addAndGet() throws SQLException {
		System.out.println("1번째 @Test 메소드, userdao의 hashcode : " + userdao.hashCode());
		userdao.deleteAll();	//모든 row 삭제
		assertThat(userdao.getCount(), is(0)); // 모든 row 갯수가 0인지 확인
		
		userdao.add(user1);	//user Insert
		userdao.add(user2);	//user Insert
		assertThat(userdao.getCount(), is(2)); //  1 user만 insert 했을테니 row가 1인지 비교
		
		User userget1 = userdao.get(user1.getId());
		assertThat(user1.getName(), is(userget1.getName()));
		assertThat(user1.getPassword(), is(userget1.getPassword()));
		
		User userget2 = userdao.get(user2.getId());
		assertThat(user2.getName(), is(userget2.getName()));
		assertThat(user2.getPassword(), is(userget2.getPassword()));
		
	}
	
	@Test
	public void count() throws SQLException {
		System.out.println("2번째 @Test 메소드, userdao의 hashcode : " + userdao.hashCode());
		System.out.println(userdao.hashCode());
		userdao.deleteAll();	//모든 row 삭제
		assertThat(userdao.getCount(), is(0)); 
		
		userdao.add(user1);	
		assertThat(userdao.getCount(), is(1)); 

		userdao.add(user2);	
		assertThat(userdao.getCount(), is(2)); 
		
		userdao.add(user3);	
		assertThat(userdao.getCount(), is(3)); 
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException {
		System.out.println("3번째 @Test 메소드, userdao의 hashcode : " + userdao.hashCode());
		System.out.println(userdao.hashCode());
		userdao.deleteAll();
		assertThat(userdao.getCount(), is(0));
		
		userdao.get("unkown_id");
	}

	
}
