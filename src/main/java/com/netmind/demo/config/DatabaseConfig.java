package com.netmind.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("spring.datasource")
public class DatabaseConfig {

	static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

	private String url;
	private String user;
	private String password;
	private String driverClassName;

	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		logger.info(url);
		logger.info(user);
		logger.info(password);
		logger.info(driverClassName);
		return url;
	}

	@Profile("pro")
	@Bean
	public String proDatabaseConnection() {
		logger.info(url);
		logger.info(user);
		logger.info(password);
		logger.info(driverClassName);
		return url;
	}
}
