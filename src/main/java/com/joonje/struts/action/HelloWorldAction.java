package com.joonje.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
	public String execute() {
		System.out.println("Structs2 HelloWorld!");
		this.addFieldError("name", "error");
		return SUCCESS;
	}
}
