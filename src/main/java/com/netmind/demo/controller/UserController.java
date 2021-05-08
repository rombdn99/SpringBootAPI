package com.netmind.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netmind.demo.dao.UserRepository;
import com.netmind.demo.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("user")
	public ResponseEntity<User> autenthicate(
			@RequestParam("user") String username,
			@RequestParam("password") String pwd) {

		String token = getJWTToken(username);
		User user = new User();
		user.setUsername(username);
		user.setPassword(pwd);
		user.setToken(token);
		User foundUser = userRepository.findByUsernameAndPassword(username,
				pwd);
		System.out.println(foundUser);
		if (foundUser == null)
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	@GetMapping(path = "/user", produces = "application/json")
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok(userRepository.findAll());
	}

	@PostMapping("/user/register")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok(userRepository.save(user));
	}

	private String getJWTToken(String username) {
		String claveSecreta = "miClaveSecreta";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, claveSecreta.getBytes())
				.compact();

		return "Bearer " + token;
	}

}
