package com.capgemini;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entity.User;
import com.capgemini.exceptions.ListIsEmptyException;
import com.capgemini.exceptions.UserNotFoundException;
import com.capgemini.service.UserManagementService;

@SpringBootTest
class BookStoreUserManagement1ApplicationTests {
   @Autowired
   UserManagementService userService;
	@Test
	void listAllUser() throws ListIsEmptyException {
		List<User> list=userService.viewAllUsers();
		assertTrue(!list.isEmpty());
	}
	@Test
	void viewUserByIdFound() throws UserNotFoundException {
		User user1 = userService.viewUserById("chris@gmail.com");
		assertNotNull(user1);
	
	}
    @Test
    void viewUserByIdNotFound() throws UserNotFoundException {
    	assertThrows(UserNotFoundException.class, ()->userService.viewUserById("jas@gmail.com"));
	
	}
    /*@Test
    void deleteById() throws UserNotFoundException {
    	String SuccessMessage=userService.removeUser("jck@gmail.com");
    	String expected="User for the given ID is deleted successfully";
    	assertEquals(SuccessMessage,expected);
    }*/
    @Test
    void deleteUserByIdNotFound() throws UserNotFoundException {
    	assertThrows(UserNotFoundException.class, ()->userService.removeUser("jas@gmail.com"));
	
	}
    @Test
    void updateUserSuccess() throws UserNotFoundException {

    	User result=new User();
    	result.setEmail("chris@gmail.com");
    	result.setFullName("chris");
    	result.setPassword("chris1212");
    	result.setUpdatedDate(LocalDate.now());
    	result.setUserId("user1222213");
    	String SuccessMessage= userService.editUser(result);
    	String expected="User details are successfully edited ";
    	assertEquals(SuccessMessage,expected);
    }
    
    
}
