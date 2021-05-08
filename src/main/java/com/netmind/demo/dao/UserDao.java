package com.netmind.demo.dao;

import org.springframework.stereotype.Repository;

import com.netmind.demo.model.User;

@Repository
public class UserDao {

	private static User users = new User();

	public User getAllUsers() {
		return users;
	}
}
