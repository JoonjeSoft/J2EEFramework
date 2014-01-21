package com.joonje.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class User extends IdEntity {
	private String name;
	private String password;
	private String sex;
	@ManyToOne
	private Role role;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
