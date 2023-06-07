package com.hwi.Signupservice.payloads;

public class JwtAutRequest {
	
	private String username ;
	private String password ;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {  //user name set 
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
