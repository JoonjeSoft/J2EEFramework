package com.joonje.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.joonje.domain.User;
import com.joonje.service.UserService;

public class HibRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String)token.getPrincipal();
		User user = userService.findUserByName(userName);
		if (user == null) {
			throw new UnknownAccountException();
		}
		String salt = "123";
		return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), ByteSource.Util.bytes(salt), super.getName());
	}

}
