package com.capgemini.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.training.daos.LoginDao;
import com.capgemini.training.model.Login;
import com.capgemini.training.util.DbUtil;

public class LoginDaoImpl implements LoginDao {
	Connection con=null;
	public LoginDaoImpl() {
		con=DbUtil.createConnection();
	}

	@Override
	public Login loginUser(String email, String pass) {
		Login login=new Login();
		try {
			String sql="select * from login where email=? "
					+ "and pass=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, pass);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				login.setLid(rs.getInt(1));
				login.setEmail(rs.getString(2));
				login.setPass(rs.getString(3));
				login.setRole(rs.getString(4));
				login.setDoc(rs.getDate(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return login;
	}

	@Override
	public void registerUser(Login login) {
		try {
		String sql="insert into login(lid, email,pass,role) "
				+ "values(?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, login.getLid());
		pst.setString(2, login.getEmail());
		pst.setString(3, login.getPass());
		pst.setString(4, login.getRole());
		pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int changePassword(String oldPassword, String newPassword, String email) {
		// TODO Auto-generated method stub
		return 0;
	}

}
