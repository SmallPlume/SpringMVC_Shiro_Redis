package org.shiro.realm;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.modules.sys.entity.User;
import com.modules.sys.service.UserService;

public class myRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
	private RuntimeSchema<User> schema = RuntimeSchema.createFrom(User.class);
	
	public final static String SESSION_KEY = "SESSION_USER";
	
	/**
	 * 用户权限、角色验证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取帐号
		String userName = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//获取帐号角色
		Set<String> roles = userService.getRoleByName(userName);
		authorizationInfo.setRoles(roles);
		//获取帐号权限
		Set<String> permis = userService.getPermitByName(userName);
		authorizationInfo.setStringPermissions(permis);
		return authorizationInfo;
	}

	/**
	 * 用户验证登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		String password = new String((char[])token.getCredentials()); //得到密码
		User user = userService.getUserByName(userName);
		if(user==null){
			throw new UnknownAccountException(); //如果用户名错误
		}
		if(!user.getPassword().equals(password)){
			throw new IncorrectCredentialsException(); //如果密码错误
		}
		SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername()
				,user.getPassword()
				,getName());
		
		//去除密码,将user对象序列化
		user.setPassword(null);
		byte[] UserBytes = ProtostuffIOUtil.toByteArray(user, schema,
				LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
		
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute(SESSION_KEY, UserBytes);
		
		return authcInfo;
	}

}
