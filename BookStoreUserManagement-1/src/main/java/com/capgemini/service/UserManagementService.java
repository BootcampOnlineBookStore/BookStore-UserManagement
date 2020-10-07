package com.capgemini.service;

import java.util.List;

import com.capgemeni.dto.UserManagementForm;
import com.capgemini.entity.User;
import com.capgemini.exceptions.ListIsEmptyException;
import com.capgemini.exceptions.UserNotFoundException;
import com.capgemini.exceptions.LoginException;

public interface UserManagementService {
public String createUser(UserManagementForm userForm);
public String editUser(User user) throws UserNotFoundException;
public String removeUser(String emailId) throws UserNotFoundException;
public List<User> viewAllUsers() throws ListIsEmptyException;
public User viewUserById(String emailId) throws UserNotFoundException;
public String validateTokenInAdminLoginService(String tokenId) throws LoginException;
}
