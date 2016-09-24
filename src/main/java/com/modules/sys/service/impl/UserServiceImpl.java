package com.modules.sys.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.modules.sys.dao.userDAO;
import com.modules.sys.entity.User;
import com.modules.sys.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private userDAO dao;
	
	@Override
	public User getUserByName(String name) {
		if(!StringUtils.isEmpty(name)){
			return dao.getUserByName(name);
		}
		return null;
	}

	@Override
	public Set<String> getRoleByName(String name) {
		if(!StringUtils.isEmpty(name)){
			return dao.getRoleByName(name);
		}
		return null;
	}

	@Override
	public Set<String> getPermitByName(String name) {
		if(!StringUtils.isEmpty(name)){
			return dao.getPermitByName(name);
		}
		return null;
	}

	@Override
	public List<User> queryUser() {
		return dao.queryUser();
	}

	@Override
	public User getUser(String id) {
		if(!StringUtils.isEmpty(id)){
			return dao.findOne(id);
		}
		return null;
	}

}
