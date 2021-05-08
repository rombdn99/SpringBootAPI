package com.netmind.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netmind.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String username, String password);

	// Optional<User> findByEmail(String email);
}
