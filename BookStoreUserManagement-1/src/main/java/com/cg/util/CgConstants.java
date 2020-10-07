package com.cg.util;

public class CgConstants {
public static final String USER= "user";
public static final String USER_NOT_FOUND = "Sorry!!! User for given email ID is not found, try with a valid  user ID";
public static final String EDITED_SUCCESSFULLY = "User details are successfully edited ";
public static final String DELETED_SUCCESSFULLY = "User for the given ID is deleted successfully";
public static final String NO_USERS = "Oops!!! There are no users to display";
public static final String USER_DELETED_SUCCESSFULLY="is deleted successfully";
public static final String EDITING_COMPLETED = " is edited successfully";
public static final String USER_CREATED = "The user is successfully created and the email ID specified is: ";
public static final String CREATE_USER_URL="/createUser";
public static final String EDIT_USER_URL="/editUser";
public static final String DELETE_USER_URL="/deleteUserByEmailId/{emailid}";
public static final String LIST_ALL_USERS_URL="/userList";
public static final String VIEW_USER_BY_ID_URL="/viewUserById/{emailId}";
public static final String LOGIN_MAIN_URL="http://localhost:7082/adminlogin/verifylogin";
public static final String USER_NOT_AUTHORIZED="you are not authorized user";
public static final String TOKEN_ID="token ID";

}
