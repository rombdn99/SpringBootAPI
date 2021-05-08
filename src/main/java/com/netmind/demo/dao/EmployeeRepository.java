package com.netmind.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netmind.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
