package com.tuhinmaji.rest.webservices.restfulwebservices;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	
	@GetMapping("/filtering")
	public someBean retrieveSomeBean() {
		return new someBean("value1","value2","value3");
	}
		@GetMapping("/filtering-dynamic")
	public MappingJacksonValue retrieveDynamicSomeBean() {
		someBean someBean=new  someBean("value1","value2","value3");
		
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept( "field1");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping =new MappingJacksonValue(someBean);
		mapping.setFilters( filters);
		return mapping;
		
	}


	 
	
}
