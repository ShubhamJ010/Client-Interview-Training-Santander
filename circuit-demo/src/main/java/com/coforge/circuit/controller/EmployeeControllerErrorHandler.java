package com.coforge.circuit.controller;

import com.coforge.circuit.model.Error;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class EmployeeControllerErrorHandler {

    @ExceptionHandler(value
            = {WebClientResponseException.class})
    public ResponseEntity<Error> handle(WebClientResponseException webClientResponseException) {

        return ResponseEntity
                .status(webClientResponseException.getRawStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Error(webClientResponseException.getRawStatusCode(),
                        webClientResponseException.getStatusText(),
                        webClientResponseException.getMessage()));
    }

}
