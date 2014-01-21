package com.joonje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.joonje.domain.Role;

@Repository
public interface IRoleDao extends PagingAndSortingRepository<Role, String> {

}
