package com.netmind.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class NetmindSpringBootProjectApplication {

	static final Logger logger = LoggerFactory
			.getLogger(NetmindSpringBootProjectApplication.class);

	public static void main(String[] args) {
		logger.info("My message before start application");
		SpringApplication.run(NetmindSpringBootProjectApplication.class, args);
		logger.info("My message after start application");
		System.out.println("Hola Mundo");

	}

}
