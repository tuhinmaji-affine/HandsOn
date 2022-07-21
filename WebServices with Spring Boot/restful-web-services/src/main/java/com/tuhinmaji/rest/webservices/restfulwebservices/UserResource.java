package com.tuhinmaji.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
@RestController
public class UserResource {
	@Autowired
	private UserDaoService service;
	//retrieveAllUser
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//retrieveUser(int id)
	@GetMapping("user/{id}")
	public User retrieveUser(@PathVariable int id)  {
		User user=service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}else {
			return user;
		}
		
	}
	@DeleteMapping("user/{id}")
	public void deleteUser(@PathVariable int id)  {
		User user=service.deleteById(id);
		if(user==null) 
			throw new UserNotFoundException("id-"+id);
		 
		
	}
	 
	//input-details of user
	//output-CREATE & return the created URI
	@PostMapping("/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User savedUser= service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId())
		.toUri();
		return ResponseEntity.created(location).build();
	}
	
}
