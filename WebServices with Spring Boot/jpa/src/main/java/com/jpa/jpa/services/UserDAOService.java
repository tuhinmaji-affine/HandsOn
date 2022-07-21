package com.jpa.jpa.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.jpa.entity.User;

@Repository
@Transactional
public class UserDAOService {
	//User tuhin=new User("Tuhin","Engineer");
	@PersistenceContext
	private EntityManager entityManager;
	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}
}
