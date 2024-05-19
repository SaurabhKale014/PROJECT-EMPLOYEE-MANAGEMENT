package com.ConnectionFactory;

import java.sql.Connection;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionFactory {
	public static Connection con;
	public static Connection getCon()
	{
		try {
			MysqlDataSource ds = new MysqlDataSource();
			ds.setUrl("jdbc:mysql://localhost:3306/saurabh");
			ds.setUser("root");
			ds.setPassword("saurabh2014");
			
			con=ds.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
