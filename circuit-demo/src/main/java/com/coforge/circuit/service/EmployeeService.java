package com.coforge.circuit.service;

import com.coforge.circuit.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(String page, String limit);
}
