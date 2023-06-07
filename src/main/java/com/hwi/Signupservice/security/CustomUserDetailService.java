package com.hwi.Signupservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hwi.Signupservice.entity.User;
import com.hwi.Signupservice.payloads.ResourceNotFoundException;
import com.hwi.Signupservice.repo.UserRepo;
@Service
public class CustomUserDetailService  implements UserDetailsService{
	@Autowired
	private UserRepo userRepo ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("not found error.."));
		
		
		return user;
	}

}
