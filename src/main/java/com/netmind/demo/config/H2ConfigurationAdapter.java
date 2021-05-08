package com.netmind.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class H2ConfigurationAdapter extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * http.authorizeRequests().antMatchers("/h2-ui/**").permitAll().and()
		 * .csrf().ignoringAntMatchers("/h2-ui/**").and().headers()
		 * .frameOptions().sameOrigin();
		 */
	}
}
