package com.jpa.jpa;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.jpa.entity.User;
import com.jpa.jpa.services.UserDAOService;
import com.jpa.jpa.services.UserRepository;

 



@Component
public class UserCommandLineRunner2 implements CommandLineRunner {
	private static final Logger log=  LoggerFactory.getLogger(UserCommandLineRunner2.class);
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String...strings) throws Exception {
		User tuhin=new User("Tuhin","Engineer");
		 userRepository.save(tuhin);
		 log.info( "New User created:"+tuhin);
		 Optional<User> user1=userRepository.findById(1L);
		 log.info( "New User retrieved:"+user1);
		 List<User> users=userRepository.findAll();
		 log.info( "All users"+users);
	}
}
