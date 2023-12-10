package com.coforge.addres2.service;


import com.coforge.addres2.Ec.AddServices;
import com.coforge.addres2.dao.EmployeeRepo;
import com.coforge.addres2.model.AddressResponse;
import com.coforge.addres2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

//	@Autowired
//	private  WebClient.Builder webClientBuilder;

    @Autowired
    private AddServices addServices;

    public List<Employee> getEmpDetails() {
        return repo.findAll();
    }

    public Employee getEmpDetailsById(int id) {
        return repo.findById(id).orElseThrow();
    }

    public AddressResponse getEmployeeAddress(int empId) {
        Employee employee = new Employee();

//        return webClientBuilder.build()
//				.get()
//				.uri("http://localhost:8081/address/{empId}",empId)
//				.retrieve()
//				.bodyToMono(AddressResponse.class)
//				.block();
        return addServices.AddService(empId);

    }


}
