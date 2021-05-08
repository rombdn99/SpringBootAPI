package com.netmind.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@NotNull(message = "The id should not be null")
	@Positive(message = "The id should be greater than 0")
	private Integer id;

	@Column(name = "firstName")
	@NotNull(message = "The firstName is mandatory")
	@NotBlank(message = "The firstName should not be blank")
	private String firtsName;

	@Column(name = "lastName")
	@NotNull(message = "The lastName is mandatory")
	@NotBlank(message = "The lastname should not be blank")
	private String lastName;

	@Column(name = "email")
	@NotNull(message = "The email is mandatory")
	@NotBlank(message = "The email should not be blank")
	@Email(message = "The email is not correct")
	private String email;

}
