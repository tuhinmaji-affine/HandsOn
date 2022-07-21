package com.example.mutation;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.response.StudentResponse;

@Service
public class Mutation implements GraphQLMutationResolver {

	
	public StudentResponse createStudent() {
		
	}
}
