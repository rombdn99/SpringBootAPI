package com.netmind.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.netmind.demo.service.JWTAuthorizationFilter;

@EnableWebSecurity
@Configuration
public class ApiWebSecurityConfigurationAdapter
		extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.csrf().disable()
		// .addFilterAfter(new JWTAuthorizationFilter(),
		// UsernamePasswordAuthenticationFilter.class)
		// .authorizeRequests()
		// .antMatchers(HttpMethod.GET, "/", "/v2/api-docs", // swagger
		// "/webjars/**", // swagger-ui webjars
		// "/swagger-resources/**", // swagger-ui resources
		// "/configuration/**", // swagger configuration
		// "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css",
		// "/**/*.js")
		// .permitAll().and().authorizeRequests().antMatchers("/h2-ui/**")
		// .permitAll().and().ignoringAntMatchers("/h2-ui/**").and()
		// .headers().frameOptions().sameOrigin().and().authorizeRequests()
		// .antMatchers(HttpMethod.POST, "/user").permitAll().anyRequest()
		// .authenticated();

		http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(),
						UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/", "/v2/api-docs", // swagger
						"/webjars/**", // swagger-ui webjars
						"/swagger-resources/**", // swagger-ui resources
						"/configuration/**", // swagger configuration
						"/*.html", "/favicon.ico", "/**/*.html", "/**/*.css",
						"/**/*.js")
				.permitAll()
				.antMatchers(HttpMethod.GET, "/employee/*", "/employeeh2/*",
						"/user", "/user/*")
				.permitAll()
				.antMatchers(HttpMethod.POST, "/employee/*", "/employeeh2/*",
						"/user", "/user/*")
				.permitAll().antMatchers("/h2-ui/**").permitAll().anyRequest()
				.authenticated();
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}
