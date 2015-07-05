package com.eagle.dao;

import java.util.List;

import com.eagle.bean.User;

public interface IUserDao {
	User findUserByName(String name) throws Exception;
	User findUserById(Long id) throws Exception;
	List<User> findAllUsers() throws Exception;
	void saveUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	
}
