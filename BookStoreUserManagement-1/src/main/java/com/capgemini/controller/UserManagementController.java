package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemeni.dto.SuccessMessage;
import com.capgemeni.dto.UserManagementForm;
import com.capgemini.entity.User;
import com.capgemini.exceptions.ListIsEmptyException;
import com.capgemini.exceptions.LoginException;
import com.capgemini.exceptions.UserNotFoundException;
import com.capgemini.service.UserManagementService;
import com.cg.util.CgConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UserManagementController {
@Autowired
public UserManagementService userService;
@SuppressWarnings("unused")
@Autowired
private RestTemplate rt;
Logger logger = LoggerFactory.getLogger(UserManagementController.class);
@PostMapping(CgConstants.CREATE_USER_URL)
public SuccessMessage createUser(@RequestHeader(name="tokenId",required=false) String tokenId, @RequestBody UserManagementForm userForm) throws LoginException {
	logger.info(CgConstants.TOKEN_ID+ tokenId);
	@SuppressWarnings("unused")
	String email=userService.validateTokenInAdminLoginService(tokenId);
	String userId=userService.createUser(userForm);
	return new SuccessMessage(CgConstants.USER_CREATED+userId);
}
@PutMapping(CgConstants.EDIT_USER_URL)
public SuccessMessage edituser(@RequestHeader(name="tokenId",required=false) String tokenId,@RequestBody User user) throws UserNotFoundException, LoginException {
	logger.info(CgConstants.TOKEN_ID+ tokenId);
	@SuppressWarnings("unused")
	String email=userService.validateTokenInAdminLoginService(tokenId);
	
	String userId=userService.editUser(user);
	return new SuccessMessage(userId+CgConstants.EDITING_COMPLETED);
	
}
@DeleteMapping(CgConstants.DELETE_USER_URL)
public SuccessMessage deleteUser(@RequestHeader(name="tokenId",required=false) String tokenId, @PathVariable("emailid") String emailId) throws UserNotFoundException, LoginException {
	logger.info(CgConstants.TOKEN_ID+ tokenId);
	@SuppressWarnings("unused")
	String email=userService.validateTokenInAdminLoginService(tokenId);
	String emailId1=userService.removeUser(emailId);
	return new  SuccessMessage(emailId1+CgConstants.USER_DELETED_SUCCESSFULLY) ;
}
@GetMapping(CgConstants.LIST_ALL_USERS_URL)
public List<User> getListOfUsers(@RequestHeader(name="tokenId",required=false) String tokenId) throws ListIsEmptyException, LoginException{
	logger.info(CgConstants.TOKEN_ID+ tokenId);
	@SuppressWarnings("unused")
	String email=userService.validateTokenInAdminLoginService(tokenId);
	List<User> userList=userService.viewAllUsers();
	return userList;
}
@GetMapping(CgConstants.VIEW_USER_BY_ID_URL)
public User viewUserById(@RequestHeader(name="tokenId",required=false) String tokenId,@PathVariable("emailId") String emailId) throws UserNotFoundException, LoginException{
	logger.info(CgConstants.TOKEN_ID+ tokenId);
	@SuppressWarnings("unused")
	String email=userService.validateTokenInAdminLoginService(tokenId);
	User user=userService.viewUserById(emailId);
	return user;
}
{
}
}
