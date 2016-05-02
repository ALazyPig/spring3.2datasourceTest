package com.zhaojun.spring.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.zhaojun.spring.model.User;
@ContextConfiguration("classpath:beans.xml")
public class UserDaoTest extends AbstractJUnit4SpringContextTests{
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="dataSource")
	private DataSource dataSource;
	@Test
	public void userDaoTest(){
		String sql = "insert into student values('4','bryant',14)";  
		Connection con;
		Statement sm;
		try {
			 con = dataSource.getConnection();
			 sm = con.createStatement();
			 sm.execute(sql); 
		} catch (SQLException e) {
			e.printStackTrace();
		}		 
		userDao.save(new User());
		
	}
	@Test
	public void userDaoTest1(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao)context.getBean("userDao");
		userDao.save(new User());
		
	}
	
}
