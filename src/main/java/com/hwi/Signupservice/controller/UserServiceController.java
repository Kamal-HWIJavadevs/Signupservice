package com.hwi.Signupservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwi.Signupservice.entity.User;
import com.hwi.Signupservice.repo.UserRepo;
import com.hwi.Signupservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserServiceController {
//	@Autowired
//	private UserRepo userRepo ;
	@Autowired
	private UserService userService ;
	
	// create user 
	@PostMapping("/addUser")
	public ResponseEntity<User> createUser(@RequestBody User user ){
		User createdUser = this.userService.createUser(user);
		
		return  ResponseEntity.ok(createdUser);
	}
	// get all user 
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = this.userService.getAllUser();
		return new  ResponseEntity<List<User>>(allUser , HttpStatus.OK);
		
	} 
	
	// get single user by the id ; 
	@GetMapping("/getSingleuser/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable Integer uid) {
		User userById = this.userService.getUserById(uid);
		
		return new ResponseEntity<User>(userById , HttpStatus.OK);
	}
	
	// delete the user using the id ; 
	@DeleteMapping("/deleteUser/{uid}")
	public void deleteUser(@PathVariable Integer uid) {
		this.userService.deleteUser(uid);
		
	}
	
	
	

}
