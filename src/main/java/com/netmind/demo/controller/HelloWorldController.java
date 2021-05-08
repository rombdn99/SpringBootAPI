package com.netmind.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netmind.demo.config.DatabaseConfig;

@RestController
public class HelloWorldController {
	static final Logger logger = LoggerFactory
			.getLogger(HelloWorldController.class);

	@Autowired
	private DatabaseConfig DatabaseConfig;

	@RequestMapping("/hello")
	public String helloWorld(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello " + name + "!!";
	}

	@RequestMapping("/")
	String home() {
		logger.info(DatabaseConfig.getUrl());
		return DatabaseConfig.devDatabaseConnection();
	}
}
