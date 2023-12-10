package com.coforge.circuit.controller;

import com.coforge.circuit.model.Employee;
import com.coforge.circuit.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping
    public List<Employee> getEmployee(@RequestParam(name = "page", required = false, defaultValue = "1") String page,
                                      @RequestParam(name = "limit", required = false, defaultValue = "10") String limit) {

        return employeeService.getEmployees(page,limit);

    }
}
