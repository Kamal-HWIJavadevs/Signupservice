package com.hwi.Signupservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hwi.Signupservice.entity.User;
import com.hwi.Signupservice.exceptions.ApiException;
import com.hwi.Signupservice.payloads.JwtAutRequest;
import com.hwi.Signupservice.payloads.JwtAuthResponse;
import com.hwi.Signupservice.security.JwtTokenHelper;
import com.hwi.Signupservice.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAutRequest request) {
		// generate token

		this.authenticate(request.getUsername(), request.getPassword());
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);

		JwtAuthResponse response = new JwtAuthResponse();

		System.out.println(token);

		response.setToken(token);

		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);

	}

	private void authenticate(String username, String password) {

		 UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);
		//
		try {
			this.authenticationManager.authenticate(authenticationToken);
		} catch (BadCredentialsException e) {

			throw new ApiException("invalid Password...");

			// handle exception
		}

	}
	// register new user api

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {

		User regisUser = this.userService.registerNewUser(user);

		return new ResponseEntity<User>(regisUser, HttpStatus.CREATED);

	}
}
