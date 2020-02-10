package com.capgemini.training.services;

import com.capgemini.training.exceptions.BuissnessException;
import com.capgemini.training.model.Login;

public interface LoginService {

	public Login loginUser(String email, String pass)throws BuissnessException;
	public void addUser(Login login)throws BuissnessException;
	public int updatePassword(String oldPassword, 
			String newPassword, String email)throws BuissnessException;
	
}
