package com.jpa.jpa.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.jpa.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
