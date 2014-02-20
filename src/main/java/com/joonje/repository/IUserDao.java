package com.joonje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.joonje.domain.User;
@Repository
public interface IUserDao extends PagingAndSortingRepository<User, String>{
	public User findByName(String name);
}
