package com.coforge.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.demo.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
