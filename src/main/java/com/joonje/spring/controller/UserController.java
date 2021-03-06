package com.joonje.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.joonje.domain.Role;
import com.joonje.domain.User;
import com.joonje.repository.IRoleDao;
import com.joonje.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private IRoleDao roleDao;

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}


	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/add")
	public void add() {
		Random rm = new Random();
		Role role = new Role();
		role.setName("管理员");
		roleDao.save(role);
		String salt = "123";
		
		//save the salt with the new account . The HashedCredentialsMatcher //will need it later when handling login attempts: user.setPasswordSalt(salt); userDAO.create(user);
		for (int i = 0; i < 10; i++) {
			int rInt = rm.nextInt(1);
			User user = new User();
			user.setId(String.valueOf(i));
			user.setName("user"+i);
			String password = "password"+i;
			String hashedPasswordBase64 = new Md5Hash(password, ByteSource.Util.bytes(salt), 1024).toBase64();
			user.setPassword(hashedPasswordBase64);
			
			user.setRole(role);
			user.setSex(rInt == 1 ? "男" : "女");
			user.setCreateDate(new Date());
			userService.add(user);
		}
	}
	@RequestMapping(value = "/delete")
	public void delete() {
		userService.deleteAll();
	}

	@RequestMapping(value = "/query")
	public @ResponseBody
	List<User> query() {
		return (List<User>) userService.findAll();
	}

	@RequestMapping(value="/query/{value}")
	public void test(@PathVariable("value") String value) {
		System.out.println(value);
	}
	@RequestMapping(value = "/querys")
	public void querySpec(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<User> users = (List<User>) userService.findAll();
		ObjectMapper mapper = new ObjectMapper();
		// first, construct filter provider to exclude all properties but
		// 'name', bind it as 'myFilter'
//		SimpleBeanPropertyFilter.serializeAllExcept(propertyArray)
		SimpleFilterProvider sp = new SimpleFilterProvider();
		FilterProvider filters = sp.addFilter("myFilter", SimpleBeanPropertyFilter.serializeAllExcept("name","id"));
		sp.addFilter("myFilter1", SimpleBeanPropertyFilter.filterOutAllExcept("name","id"));
		// and then serialize using that filter provider:
		mapper.setFilters(filters);
		String json = mapper.writeValueAsString(users);
		response.getWriter().println(json);
		System.out.println(json);
	}
}
