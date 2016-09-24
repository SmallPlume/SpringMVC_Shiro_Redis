package org.spring.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.modules.sys.entity.User;

public class ArgumentResolver implements WebArgumentResolver{

	public final static String SESSION_KEY = "SESSION_USER";
	
	private RuntimeSchema<User> schema = RuntimeSchema.createFrom(User.class);
	/**
	 * 获取用户
	 * @return
	 */
	private User getUser(){
		Session session = SecurityUtils.getSubject().getSession();
		byte[] userBytes = (byte[]) session.getAttribute(SESSION_KEY);
		User user = schema.newMessage();
		ProtostuffIOUtil.mergeFrom(userBytes, user, schema);
		return user;
	}
	
	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
		if(methodParameter.getParameterType().equals(User.class)){
			//通过线程用户获取用户信息
			User user = getUser();
			if(user!=null){
				return user;
			}
		}
		return WebArgumentResolver.UNRESOLVED;
	}
	
}
