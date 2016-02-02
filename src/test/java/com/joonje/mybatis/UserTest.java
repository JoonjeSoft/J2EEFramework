package com.joonje.mybatis;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.joonje.domain.User;
import com.joonje.service.UserService;

//@ActiveProfiles("mybatis")
//@ContextConfiguration(locations="classpath:spring/root-context.xml")
public class UserTest /*extends AbstractJUnit4SpringContextTests*/ {
//	@Autowired
//	public UserService userService;
	
	@Test
	public void testMapper() {
//		User user = userService.findUserByName("user2");
//		System.out.println(user.getName());
		System.out.println("test");
	}
}
