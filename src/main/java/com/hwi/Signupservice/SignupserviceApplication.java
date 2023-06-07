package com.hwi.Signupservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SignupserviceApplication implements CommandLineRunner {
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder ;

	public static void main(String[] args) {
		SpringApplication.run(SignupserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		String encodePass = bCryptPasswordEncoder.encode("abc");
//		
//		System.out.println("the encrypted password is :"+encodePass);
		
	}
	
	
	//password encoder bean 
//	  @Bean
//	    public BCryptPasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//	

}
