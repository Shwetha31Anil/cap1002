package com.capgemini.training.serviceimpl;

import com.capgemini.training.daoimpl.LoginDaoImpl;
import com.capgemini.training.daos.LoginDao;
import com.capgemini.training.exceptions.BuissnessException;
import com.capgemini.training.model.Login;
import com.capgemini.training.services.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao loginDao=null;
	
	public LoginServiceImpl() {
		loginDao=new LoginDaoImpl();
	}
	

	@Override
	public Login loginUser(String email, String pass)throws BuissnessException {
		return loginDao.loginUser(email, pass);
	}

	@Override
	public void addUser(Login login)throws BuissnessException {
		if(login.getLid()>100 && login.getLid()<999) {
			if(login.getEmail() != null &&
					login.getEmail().matches("([a-zA-Z0-9_]{5,12})@cap.com")) {
				if(login.getPass()!=null &&
						login.getPass().matches("[a-zA-Z0-9]{8}")) {
					if(login.getRole().equalsIgnoreCase("admin")
							|| login.getRole().equalsIgnoreCase("customer")) {		
				loginDao.registerUser(login);
					}else {
						throw new BuissnessException("role allowed only customer or admin");
					}
				}else {
					throw new BuissnessException("password length is 8");
				}
			}else {
				throw new BuissnessException("email pattern not matching");
			}
		}else {
			throw new BuissnessException("3 digits only allowed");
		}
	}

	@Override
	public int updatePassword(String oldPassword, String newPassword, String email)throws BuissnessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
