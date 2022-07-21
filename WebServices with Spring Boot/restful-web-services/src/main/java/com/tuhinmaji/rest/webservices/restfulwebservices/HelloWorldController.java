package com.tuhinmaji.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorldController {
	//GET
	//URI -/helloworld
	//method -"Hello Wrold"
	
	//good.morning.message
	@Autowired
	private MessageSource messageSource;
	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	@GetMapping(path="/hello-world-bean/{name}")
	public HelloWorldBean HelloWorldBeanPath(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s",name));
	}
	@GetMapping(path="/hello-world-international")
	public String HelloWorldInternational(@RequestHeader(name="Accept-Language",required=false) Locale locale ) {
		//return "Hello World";
		return messageSource.getMessage("good.morning.message",null,"default message",locale);
	}
}
