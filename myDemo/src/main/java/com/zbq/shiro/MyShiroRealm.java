package com.zbq.shiro;



import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyShiroRealm extends AuthorizingRealm {
	
	// 角色权限和对应权限添加
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// 获取登录用户名
//		String name = (String) principalCollection.getPrimaryPrincipal();
//		// 添加角色和权限
//		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//
//		// 添加角色
//		simpleAuthorizationInfo.addRole("admin");
//
//		// 添加权限
//		simpleAuthorizationInfo.addStringPermission("create");

		return null;
	}

	// 用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken atoken) throws AuthenticationException {


		UsernamePasswordToken token = (UsernamePasswordToken) atoken;

		String name = token.getUsername();
		
		String username="admin";
		String password="123456";

		if (!name .equals(username)) {
			return null;
		} 
		// 这里验证authenticationToken和simpleAuthenticationInfo的信息
		//SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, "123456", getName());
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, "");
		return simpleAuthenticationInfo;

	}

}