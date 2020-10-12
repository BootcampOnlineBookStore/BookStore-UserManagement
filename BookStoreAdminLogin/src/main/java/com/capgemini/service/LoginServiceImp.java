package com.capgemini.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.ILoginDao;
import com.capgemini.entity.User;
import com.capgemini.exceptions.LoginException;
import com.capgemini.util.CgConstants;

/**
* Class: LoginServiceImp
* Description: The LoginServiceImp class provides the methods that implement login functionality,logout, verify login
  Each method has a functionality.
* @author  SAISHIVA
* @version 1.0
* CreatedOn   2020-10-07 
*/
@Service
public class LoginServiceImp implements LoginService{

	@Autowired
	private ILoginDao dao;
	
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImp.class);
	
	/**
	 * Method: doLogin 
	 * Description: implements the login functionality
	 * it returns login successful if the credentials are correct
	 * @throws LoginException 
	 */
	@Override
	public User doLogin(String email, String password)throws LoginException {
		User user = null;
		logger.debug(CgConstants.LOGIN_REQUEST_UNDER_PROCESSING);
		Optional<User> optUser = dao.findById(email);
		if (optUser.isPresent()) {
			user = optUser.get();
			if(!user.getPassword().contentEquals((password)))
				throw new LoginException(CgConstants.CHECK_YOUR_PASSWORD);
			logger.info(CgConstants.USER_AUTHENTICATED + email);
			return user;
		}
		
		throw new LoginException(CgConstants.CHECK_YOUR_CREDENTIALS);
	}
	/**
	 * Method: encryptUser 
	 * Description: encrypts the credentials   
	 */
	@Override
	public String encryptUser(User user) {
		return encryptString(user.getFullName())+"-" +encryptString(user.getPassword())+"-"+encryptString(user.getEmail())+"-"+encryptString(user.getRole());
	}
	/**
	 * Method: encryptString method 
	 * Description: consists of the encryption logic
	 * @param str
	 * @returns the encrypted string
	 */
	public String encryptString(String str) {
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch ;
		for (int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]+3;
			sb.append((char)ch);
		}
		return sb.toString();
	}
    /**
     * Method: decryptString 
     * Description: method consists of the decrypt logic for decrypting the string
     * @param str
     * @returns the decrypt string
     */
	public String decryptString(String str) {
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch ;
		for (int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]-3;
			sb.append((char)ch);
		}
		return sb.toString();
	}

	
}
