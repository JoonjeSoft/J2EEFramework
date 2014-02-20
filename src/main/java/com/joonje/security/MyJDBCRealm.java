package com.joonje.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.joonje.domain.User;
import com.joonje.service.UserService;

public class MyJDBCRealm extends AuthorizingRealm{
	private UserService userService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String userName = usernamePasswordToken.getUsername();
		User user = userService.findUserByName(userName);
		if(user==null) {
			throw new UnknownAccountException("用户名不存在！");
		}
		return new SimpleAuthenticationInfo(user.getName(),user.getPassword(),"MyRealm");
	}

}
