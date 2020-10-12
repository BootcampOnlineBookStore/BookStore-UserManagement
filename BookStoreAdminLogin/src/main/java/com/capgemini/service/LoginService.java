package com.capgemini.service;

import com.capgemini.entity.User;
import com.capgemini.exceptions.LoginException;
/**
 * The interface LoginService is used for declaring abstract methods in an interface that are implemented in a service class
 * @author SAISHIVA
 *
 */
public interface LoginService {
    public User doLogin(String email, String password)throws LoginException;
    public String encryptUser(User user);
    
}
