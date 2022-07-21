package com.tuhinmaji.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@Component
public class UserDaoService {
	private static List<User> users =new ArrayList<User>();
	private static int userCount=3;
	static {
		users.add(new User(29,"Tuhin",new Date()));
		users.add(new User(27,"Amit",new Date()));
		users.add(new User(26,"Rohit",new Date()));
	}
	public List<User> findAll(){
		return users;
	}
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	public User deleteById(int id) {
		Iterator<User> iterator =users.iterator();
		while(iterator.hasNext()) {
			User user=iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}else{
				return null;
			}
			
		}
		return null;
	}
}
