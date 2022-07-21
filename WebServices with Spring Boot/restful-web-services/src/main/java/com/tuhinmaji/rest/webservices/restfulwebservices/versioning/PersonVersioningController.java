package com.tuhinmaji.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	@GetMapping("/v1/person")
	public Person person() {
		return new Person("Tuhin Maji");
	}
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Tuhin","Maji"));
	}
}
