package com.coforge.demo.service;

import java.util.List;

import com.coforge.demo.model.AddressResponse;
import com.coforge.demo.model.Emo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.demo.dao.EmployeeRepo;
import com.coforge.demo.model.Employee;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

	@Autowired
	private  WebClient.Builder getwebclientbuilder;


    public List<Employee> getEmpDetails() {
        return repo.findAll();
    }

    public Employee getEmpDetailsById(int id) {
        return repo.findById(id).orElseThrow();
    }

    public AddressResponse getEmployeeAddress(int empId) {
        return getwebclientbuilder.build()
				.get()
				.uri("/address/{empId}",empId)
				.retrieve()
				.bodyToMono(AddressResponse.class)
				.block();

    }
    @Autowired
    private WebClient webClients;

//    public void webctest()
//    {
//        Mono<String>stringMono=webClient.build().get()
//                .uri("/?noofRecords=10&idStarts=1001")
//                .retrieve()
//                .bodyToMono(String.class);
//
//        stringMono.subscribe(System.out::println);
//    }

    public void webctest1()
    {
        Mono<Emo> stringMono= webClients.get()
                .uri("")
                .retrieve()
                .bodyToMono(Emo.class);

        stringMono.map(Emo::getImageUrl).subscribe(
                System.out::println
        );
    }


}
