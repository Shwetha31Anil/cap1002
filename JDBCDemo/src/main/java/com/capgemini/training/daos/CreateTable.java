package com.capgemini.training.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.training.util.DbUtil;

public interface CreateTable {	
	public  static boolean tableCreate() {
		String sql="create table product("
				+ "pid number primary key,"
				+ "pname varchar(15) not null,"
				+ "qty number,"
				+ "price number(10,2),"
				+ "brand varchar(10))";
		boolean status=false;
		Connection con=DbUtil.createConnection();
		try {
		Statement st =con.createStatement();
		status= st.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
				return status;
	}
	
	public  static boolean tableCreate2() {
		String sql="create table login("
				+ "lid number primary key,email varchar(25) not null,"
				+ "pass varchar(100),"
				+ "role varchar(10),"
				+ "doc date default sysdate)";
		boolean status=false;
		Connection con=DbUtil.createConnection();
		try {
		Statement st =con.createStatement();
		status= st.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
				return status;
	}

	

}
