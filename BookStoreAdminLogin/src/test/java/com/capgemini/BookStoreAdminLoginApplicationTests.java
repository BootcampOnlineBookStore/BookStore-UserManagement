package com.capgemini;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entity.User;
import com.capgemini.exceptions.LoginException;
import com.capgemini.service.LoginService;
/**
 * Class: BookStoreAdminLoginApplicationTests
 * Description: Test cases for Login module
 * @author SAISHIVA
 * CreatedOn: 2020-10-09
 */
@SpringBootTest
class BookStoreAdminLoginApplicationTests {
    @Autowired
    private LoginService service;
	/**
	 * Test: ValidDetails
	 * Description: test case for testing login functionality by giving valid details
	 * @throws LoginException
	 */
    
    @Test
	public void ValidDetails() throws LoginException {
		User result =new User();
		User details=new User();
		result.setEmail("sais7654@gmail.com");
		result.setPassword("saishiva123");
		result.setFullName("Sai shiva kumar");
		result.setRole("admin");
		result.setUpdatedDate(LocalDate.of(2020, 10, 11));
		result.setUserId("user29131311102020");
		details=service.doLogin("sais7654@gmail.com", "saishiva123");
	    Assertions.assertEquals(result.toString(), details.toString());
	}
    /**
     * Test: InvalidLogin
     * Description: test case for testing login functionality by giving invalid details
     * @throws LoginException
     */
    @Test
    public void InValidDetails() throws LoginException {
    	String email="sais7654@gmail";
		String password="jack123";
		assertThrows(LoginException.class, ()->service.doLogin(email,password));
	
	}
}
