package com.joonje.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joonje.domain.Role;
import com.joonje.domain.User;
import com.joonje.repository.IRoleDao;
import com.joonje.repository.IUserDao;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRoleDao roleDao;
	public IRoleDao getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public IUserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	@RequestMapping(value="/add")
	public void add() {
		Role role = new Role();
		role.setName("π‹¿Ì‘±");
		roleDao.save(role);
		for(int i=0;i<10;i++) {
			User user = new User();
			user.setId(String.valueOf(i));
			user.setName("user"+i);
			user.setPassword("password"+i);
			user.setRole(role);
			userDao.save(user);
		}
	}
	@RequestMapping(value="/query")
	public @ResponseBody List<User> query() {
		return (List<User>)userDao.findAll();
	}
}
