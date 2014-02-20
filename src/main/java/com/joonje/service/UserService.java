package com.joonje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joonje.domain.User;
import com.joonje.repository.IUserDao;

@Service
public class UserService {
	@Autowired
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public User findUserByName(String name) {
		return userDao.findByName(name);
	}

	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}
	
	public User add(User user) {
		return userDao.save(user);
	}
}
