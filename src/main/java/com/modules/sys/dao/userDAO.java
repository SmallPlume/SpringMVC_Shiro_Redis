package com.modules.sys.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.modules.sys.entity.User;

public interface userDAO {
	
	/**
	 * 根据帐号查询用户信息
	 * @param name
	 * @return
	 */
	public User getUserByName(@Param("username") String name);
	
	/**
	 * 根据id查询用户角色信息
	 * @param id
	 * @return
	 */
	public Set<String> getRoleByName(@Param("username") String name);
	
	/**
	 * 根据帐号查询权限
	 * @param name
	 * @return
	 */
	public Set<String> getPermitByName(@Param("username") String name);

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
	public User findOne(@Param("id") String id);
	
}
