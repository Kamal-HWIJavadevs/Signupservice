package com.hwi.Signupservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hwi.Signupservice.security.CustomUserDetailService;
import com.hwi.Signupservice.security.JwtAuthenticationEntryPoint;
import com.hwi.Signupservice.security.JwtAuthenticationfilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailService customUserDetailService ;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    JwtAuthenticationfilter jwtAuthenticationfilter ;

	
	  public static final String[] PUBLIC_URLS = {
                      	"/api/auth/**"     // this is Allowed url for generate token ;
    		
	    };
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
		
		
	}
	
	
    
    
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// api configuration 
			
		      http.csrf()
		        .disable()
		            .cors()
		            .disable()
		            .authorizeHttpRequests()
		              .antMatchers(PUBLIC_URLS).permitAll()                                       //ye dono api chlengi user register hoga aur token bhu generate hoga
		              .antMatchers(HttpMethod.GET).permitAll()
		                .anyRequest().authenticated()
		            .and()
		            .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
		            .and()
		             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		        
		        http.addFilterBefore(jwtAuthenticationfilter,UsernamePasswordAuthenticationFilter.class);
		             
	}





		@Bean
		public PasswordEncoder passwordEncoder() {
			
			return new BCryptPasswordEncoder();
		}

		@SuppressWarnings("deprecation")
		@Override
		
		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception {

			return authenticationManagerBean();
		}

}
