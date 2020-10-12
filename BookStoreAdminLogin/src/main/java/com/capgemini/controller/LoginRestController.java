package com.capgemini.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.User;
import com.capgemini.exceptions.LoginException;
import com.capgemini.service.LoginService;
import com.capgemini.util.CgConstants;
/**
 * LoginRestController is a RestController that handles the incoming requests an returns the response 
 * to the client
 * @author SAISHIVA
 *@version 1.0
 * CreatedOn:2020-10-07
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class LoginRestController {
    
	@Autowired
	private LoginService ser;
    Logger logger = LoggerFactory.getLogger(LoginRestController.class);
	
	private Map<String, User> authMap = new HashMap<>();
	
	/**
	 * Method: getLogin 
	 * Description: is a method handler that handles the incoming login request
	 * @param email
	 * @param password
	 * @return the token which are further encrypted for safety
	 * @throws LoginException when there are invalid credentials
	 */
	@PostMapping(value = CgConstants.LOGIN_URL)
	public String getLogin(@RequestParam("email") String email, 
			@RequestParam("password") String password) throws LoginException {
		logger.info(CgConstants.USER_ID + email);
		logger.debug(CgConstants.USER_ID_RECEIVED);
		User user = ser.doLogin(email, password);
        String token = ser.encryptUser(user);
		authMap.put(token, user);
		return token;
	}
    /**
     * verifyLogin is used for verifying the login credentials
     * @param tokenId
     * @return the role
     * @throws LoginException
     */
	@PostMapping(value = CgConstants.VERIFY_LOGIN)
	public String verifyLogin(@RequestBody String tokenId) throws LoginException {
		logger.info(CgConstants.TOKEN_ID + tokenId);
		String role = null;
		User user = null;
		logger.info(CgConstants.AUTHORIZATION + authMap.containsKey(tokenId));
		if (authMap.containsKey(tokenId)) {
			user = authMap.get(tokenId);
			logger.info(user.getFullName()+" "+user.getRole());
			return user.getRole();
		}
					
		return role;
	}
	/**
	 * logout removes the token and as the token is removed the user will be in logout state
	 * @param token
	 * @param req
	 * @return the message that user logged out
	 */
	@GetMapping(value = CgConstants.LOGOUT)
	public String logout(@RequestHeader("tokenId") String token,
			HttpServletRequest req) {
		authMap.remove(token);
		return CgConstants.LOGGED_OUT;
	}

	
}
