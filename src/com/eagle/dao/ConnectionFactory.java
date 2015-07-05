package com.eagle.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		try {
			Properties p = new Properties();
			p.load(ConnectionFactory.class.
					getClassLoader().getResourceAsStream("com/eagle/file/db.properties"));
			
			 driver = p.getProperty("driver");
			 url=p.getProperty("url");
			 username=p.getProperty("username");
			 password= p.getProperty("password");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) throws Exception {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}
	public static void close(Statement stmt, Connection conn) throws Exception {
		close(null,stmt,conn);
	}
}
