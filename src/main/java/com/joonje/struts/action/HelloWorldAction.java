package com.joonje.struts.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.joonje.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
	private static final long serialVersionUID = -161844580068457744L;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		System.out.println("Structs2 HelloWorld!");
		this.addFieldError("name", "error");
		return SUCCESS;
	}

	public String dynamicMethod() {
		System.out.println("DynamicMethod invoke");
		return SUCCESS;
	}

	public String param() {
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		return "param";
	}
	
	public String httpElement() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("joonje", "ok");
		HttpSession session =  request.getSession();
		session.setAttribute("session", "2");
		ServletContext application = session.getServletContext();
		application.setAttribute("config", "abc");
		return "http";
	}
	
	public String input() {
		return "input";
	}
	public String dispatcher() {
		return "dispatcher";
	}
	public String redirect() {
		return "redirect";
	}
	public String redirectAction() {
		return "redirectAction";
	}
}
