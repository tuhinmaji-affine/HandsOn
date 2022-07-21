package com.jpa.jpa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.jpa.entity.User;
import com.jpa.jpa.services.UserDAOService;



@Component
public class UserCommandLineRunner implements CommandLineRunner {
	private static final Logger log=  LoggerFactory.getLogger(UserCommandLineRunner.class);
	@Autowired
	private UserDAOService userDaoService;
	@Override
	public void run(String...strings) throws Exception {
		User tuhin=new User("Tuhin","Engineer");
		long id =userDaoService.insert(tuhin);
		log.info( "New User created:"+id);
	}
}
