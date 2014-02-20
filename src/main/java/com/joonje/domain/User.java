package com.joonje.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@JsonFilter(value="myFilter")
public class User extends IdEntity {
	private String name;
	private String password;
	private String sex;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale="zh_CN",timezone="Asia/Shanghai")
	private Date createDate;
	@ManyToOne
	@JsonIgnore
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
