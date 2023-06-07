package com.hwi.Signupservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hwi.Signupservice.entity.Role;
import com.hwi.Signupservice.entity.User;
import com.hwi.Signupservice.exceptions.ResourceNotFoundException;
import com.hwi.Signupservice.pay.AppConstents;
import com.hwi.Signupservice.repo.RoleRepo;
import com.hwi.Signupservice.repo.UserRepo;
import com.hwi.Signupservice.service.UserService;

@Service
public class UserServiceImpl  implements UserService {
	@Autowired
	private UserRepo userRepo ;
	
	@Autowired
	private PasswordEncoder passwordEncoder ;
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User savedUser = this.userRepo.save(user);
		
		return savedUser ;
	}

	@Override
	public User getUserById(Integer uid) {
		User user = this.userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("User","User Id",uid));
		
		return user;}

	@Override
	public List<User> getAllUser() {
		List<User> users = this.userRepo.findAll();
		return users ;
	}

	@Override
	public User updateUser(User user, Integer uid ) {
	User user2 = this.userRepo.findById(uid ).orElseThrow(() -> new  ResourceNotFoundException("User ","User_Id ",uid ));
      user2.setUsername(user.getUsername());
      user2.setEmailId(user.getEmailId());
      user2.setPassword(user.getPassword());
      User updatedUser = this.userRepo.save(user2);
		return updatedUser;
	}

	@Override
	public void deleteUser(Integer uid) {
		 User user = this.userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("user", "Id  ",uid));
		   this.userRepo.delete(user);
		}

	

//register user 
	@Override
	public User registerNewUser(User user) {
		
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));  //setting encoded password 
		//roles 
		Role role = this.roleRepo.findById(AppConstents.NORMAL_USER).get();
		user.getRoles().add(role);
		User newUser = this.userRepo.save(user);
		return newUser;
	}
		
	}


