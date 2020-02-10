package com.capgemini.training.daos;

import com.capgemini.training.model.Login;

public interface LoginDao {
	
	public Login loginUser(String email, String pass);
	public void registerUser(Login login);
	public int changePassword(String oldPassword, 
			String newPassword, String email);
	

}
