package com.eagle.service;

import com.eagle.bean.User;
import com.eagle.dao.IUserDao;
import com.eagle.dao.IUserDaoImpl;

public class UserServiceImpl implements IUserService{
	private static IUserDao dao=new IUserDaoImpl();
	public void register(User user) throws Exception {
		User findUser=dao.findUserByName(user.getName());
		if(findUser!=null){
			throw new Exception("用户名已经被占用!");
		}else{
			dao.saveUser(user);
		}
	}
	public User login(String username, String password) throws Exception {
		User user=dao.findUserByName(username);
		if(user==null){
			throw new Exception("登录用户名不存在!");
		}
		if(!user.getPassword().equals(password)){
			throw new Exception("密码不正确!!!");
		}
		
		return user;
	}

}
