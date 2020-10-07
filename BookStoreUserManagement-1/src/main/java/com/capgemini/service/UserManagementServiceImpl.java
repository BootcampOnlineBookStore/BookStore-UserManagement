package com.capgemini.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.capgemeni.dto.UserManagementForm;
import com.capgemini.dao.UserManagementDao;
import com.capgemini.entity.User;
import com.capgemini.exceptions.ListIsEmptyException;
import com.capgemini.exceptions.LoginException;
import com.capgemini.exceptions.UserNotFoundException;
import com.cg.util.CgConstants;
//service class
@Service
@Transactional(readOnly = true)
public class UserManagementServiceImpl implements UserManagementService {
@Autowired
private UserManagementDao userDao;
@Autowired
private RestTemplate rt;

@SuppressWarnings("unused")
@Override
@Transactional(readOnly=false)
//For creating a user
public String createUser(UserManagementForm userForm) {
	User user=new User();
	LocalDateTime now = LocalDateTime.now();
	LocalDate now1=LocalDate.now();
	String id=CgConstants.USER+now.getSecond()+now.getMinute()+now.getHour()+now.getDayOfMonth()+now.getMonthValue()+now.getYear();
	user.setUserId(id);
	user.setEmail(userForm.getEmail());
	user.setFullName(userForm.getFullName());
	user.setPassword(userForm.getPassword());
	user.setUpdatedDate(LocalDate.now());
	userDao.save(user);
	return user.getUserId();
}

@Override
@Transactional(readOnly = false)
public String editUser(User user) {
	user.setUpdatedDate(LocalDate.now());
	userDao.save(user);
	return CgConstants.EDITED_SUCCESSFULLY;
}

@Override
@Transactional(readOnly = false)
public String removeUser(String emailId) throws UserNotFoundException {
	User user=viewUserById(emailId);
	if(user == null) 
		throw new UserNotFoundException(CgConstants.USER_NOT_FOUND);
	
	userDao.delete(user);
	return CgConstants.DELETED_SUCCESSFULLY;
}

@Override
public List<User> viewAllUsers() throws ListIsEmptyException {
	List<User> lst = userDao.findAll();
	if(lst.isEmpty())
		throw new ListIsEmptyException(CgConstants.NO_USERS);
	lst.sort((e1,e2)->e1.getFullName().compareTo(e2.getFullName()));
	return lst;
	
}

@Override
public User viewUserById(String emailId) throws UserNotFoundException {
	Optional<User> opt =  userDao.findById(emailId);
	if(opt.isPresent()) {	
	return opt.get();
	}
	else {
		throw new UserNotFoundException(CgConstants.USER_NOT_FOUND);
	}
}

@Override
public String validateTokenInAdminLoginService(String tokenId) throws LoginException{
	if(tokenId==null||tokenId.length()==0)
		throw new LoginException(CgConstants.USER_NOT_AUTHORIZED);
	String url=CgConstants.LOGIN_MAIN_URL;
	String email=rt.postForObject(url, tokenId, String.class);
	return email;
}




}
