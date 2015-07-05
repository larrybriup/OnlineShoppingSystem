package com.eagle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eagle.bean.User;

public class IUserDaoImpl implements IUserDao {
	
	private static ConnectToDB ctb = new ConnectToDB();

	public User findUserByName(String name) throws Exception {
		String sql = "select * from t_user where name='" + name + "'";
		Object o = ctb.query(sql);

		ResultSet rs = (ResultSet) o;

		User u = null;
		while (rs.next()) {
			long id = rs.getLong("id");
			String username = rs.getString("name");
			String password = rs.getString("password");
			int age = rs.getInt("age");

			u = new User(id, username, password, age);
		}

		return u;
	}

	public User findUserById(Long id) throws Exception {

		String sql = "select name,password,age from t_user where id=" + id;
		Object o = ctb.query(sql);

		ResultSet rs = (ResultSet) o;

		User u = null;
		while (rs.next()) {
			String name = rs.getString("name");
			String password = rs.getString("password");
			int age = rs.getInt("age");

			u = new User(name, password, age);
		}

		return u;
	}

	public List<User> findAllUsers() throws Exception {
		String sql = "select * from t_user";
		Object o = ctb.query(sql);

		ResultSet rs = (ResultSet) o;

		User u = null;
		List<User> list = new ArrayList<User>();
		while (rs.next()) {
			String name = rs.getString("name");
			String password = rs.getString("password");
			int age = rs.getInt("age");

			u = new User(name, password, age);
			list.add(u);
		}
		return list;
	}

	public void saveUser(User user) throws Exception {
		String sql = "insert into t_user(id,name,password,age) values(t_user_id_sequence.nextval,'"
				+ user.getName()
				+ "','"
				+ user.getPassword()
				+ "',"
				+ user.getAge() + ")";
		ctb.execute(sql);
	}

	public void updateUser(User user) throws Exception {
		String sql = "update t_user set password='" + user.getPassword()
				+ "',age=" + user.getAge() + " where name='" + user.getName()
				+ "'";
		ctb.execute(sql);
	}
}
