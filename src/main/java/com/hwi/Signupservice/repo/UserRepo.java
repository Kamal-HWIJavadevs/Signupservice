package com.hwi.Signupservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hwi.Signupservice.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
	
	// all are the  custom finder methods here to connect to the data base; 
	
	Optional<User> findByUsername(String username);

	

}
