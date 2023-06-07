package com.hwi.Signupservice.service;

import java.util.List;

import com.hwi.Signupservice.entity.User;

public  interface  UserService {
	
	//create or add user here 
	
    User createUser(User user);
	
	
	// get the user of single id 
    User getUserById(Integer uid );
    
    // get the users all ; 
    List<User> getAllUser();
	
	// update the user by id ; 
	User updateUser(User user ,Integer uid);
	
   // delete the user by id  ; 
	void deleteUser(Integer uid);
	
	//for registering new user to spring security
	  
	User registerNewUser(User user);
	
	
	 

}
