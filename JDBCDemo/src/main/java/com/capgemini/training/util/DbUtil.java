package com.capgemini.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static Connection con=null;
	public static Connection createConnection() {
		try {
	    	Class.forName("oracle.jdbc.OracleDriver");
	    	con= DriverManager.getConnection(url, "capgemini1", "cap1");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
