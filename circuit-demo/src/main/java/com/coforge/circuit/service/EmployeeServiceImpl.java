package com.coforge.circuit.service;

import com.coforge.circuit.config.WebClientConfig;
import com.coforge.circuit.model.Employee;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final WebClient webClient;
    private final WebClientConfig webClientConfig;

    @Override
    @CircuitBreaker(name = "getEmployees", fallbackMethod = "getEmployeesFallback")
    @Retry(name = "getEmployees")
    public List<Employee> getEmployees(String page, String limit) {

        List<Employee> employeeList = null;

        try {
            employeeList = webClient.get()
                    .uri(UriComponentsBuilder.fromUriString(webClientConfig.getEmployeeUrl())
                            .queryParam("idStarts", page)
                            .queryParam("noofRecords", limit)
                            .toUriString())
                    .retrieve()
                    .onStatus(HttpStatus::isError, ClientResponse::createException)
                    .toEntity(new ParameterizedTypeReference<List<Employee>>() {
                    })
                    .block().getBody();

        } catch (WebClientResponseException webClientResponseException) {

            log.error("Error occur while calling API status {}, body {}",
                    webClientResponseException.getRawStatusCode(), webClientResponseException.getResponseBodyAsString());
            throw webClientResponseException;
        }

        return employeeList;
    }

    public List<Employee> getEmployeesFallback(String page, String limit, CallNotPermittedException callNotPermittedException) {
        log.error("Fallback is called when open");

        return new ArrayList<>();
    }
}