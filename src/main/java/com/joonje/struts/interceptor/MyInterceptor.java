package com.joonje.struts.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -2055110443440783850L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("before invoke");
		String result = invocation.invoke();
		System.out.println("after invoke");

		return result;
	}

}
