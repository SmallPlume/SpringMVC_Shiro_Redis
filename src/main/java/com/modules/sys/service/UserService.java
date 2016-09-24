package com.modules.sys.service;

import java.util.List;
import java.util.Set;

import com.modules.sys.entity.User;

public interface UserService {
	
	/**
	 * 根据帐号查询用户信息
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
	
	/**
	 * 根据id查询用户角色信息
	 * @param name
	 * @return
	 */
	public Set<String> getRoleByName(String name);
	
	/**
	 * 根据帐号查询权限
	 * @param name
	 * @return
	 */
	public Set<String> getPermitByName(String name);
	
	/**
	 * 查询全部用户
	 * @return
	 */
	public List<User> queryUser();
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	public User getUser(String id);

}
