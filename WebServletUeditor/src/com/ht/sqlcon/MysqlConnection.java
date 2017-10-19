package com.ht.sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

	public static String driver = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/mysqlstudy?useUnicode=true&amp;characterEncoding=utf-8&amp;useSSL=false";
	public static String username = "root";
	public static String password = "123456";
	static Connection con = null;
	static {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功！");
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection beginConnection() {
		try {
			if (con.isClosed()) {
				con = DriverManager.getConnection(url, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
//	public static void main(String[] arg){
//		System.out.println("开始连接！");
//		beginConnection();
//
//	}
}
