package com.example.restfulwebservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	
	//GET method
	//URI /hello-world
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	//Returning Bean
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World!");
	}
	
	//Returning Bean
		@GetMapping("/hello-world-bean/path-variable/{name}")
		public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello World!,%s",name));
		}
}
