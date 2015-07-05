package com.eagle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.eagle.bean.User;


public class ConnectToDB {
	private  Connection conn=null;
	private  Statement stmt=null;
	
	/*create table t_user(
	id number primary key,
	name varchar2(32) unique not null,
	age number(4)
		);
	 * */
	public ConnectToDB(){
		init();
		
	}
	private void init() {
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void execute(String sql) throws Exception{
		stmt.execute(sql);

		conn.commit();
		
//		ConnectionFactory.close(stmt,conn);
		
	}
	public Object query(String sql) throws Exception{
		ResultSet rs = stmt.executeQuery(sql);
		Object o=rs;
		
		conn.commit();
		
//		ConnectionFactory.close(stmt, conn);
		
		return o;
	}
	
}
