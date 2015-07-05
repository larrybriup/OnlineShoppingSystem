package com.eagle.service;

import com.eagle.bean.User;

public interface IUserService {
	void register(User user) throws Exception;
	User login(String username,String password) throws Exception;
}
