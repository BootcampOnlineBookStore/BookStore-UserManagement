package com.capgemini.service;

import com.capgemini.entity.User;
import com.capgemini.exceptions.LoginException;

public interface LoginService {
    public User doLogin(String email, String password)throws LoginException;
    public String encryptUser(User user);
    
}
