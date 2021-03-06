package com.radiotherapy.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.radiotherapy.model.User;
import com.radiotherapy.service.UserService;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;

	/**
	 * 提供用户信息返回权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {		
		Set<String> roleNames = new HashSet<String>();
	    Set<String> permissions = new HashSet<String>();
	    //roleNames.add("admin");//添加角色。对应到index.jsp
	    //roleNames.add("authc");
	    permissions.add("create");//添加权限,对应到index.jsp
	    permissions.add("/");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
	    info.setStringPermissions(permissions);
		return info;
	}
	
	/*
	 * 首先执行这个登录验证
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//获取用户身份这里是账号
		String number = token.getPrincipal().toString();
		User user = userService.getUserByNumber(number);
		if(user == null){
			//如果账号不存在抛出账号不存在异常
			throw new UnknownAccountException();
		}
		//以用户id和账号作为salt
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getId() + user.getName());
		return new SimpleAuthenticationInfo(number, user.getPassword(),credentialsSalt, getName());
	}
}