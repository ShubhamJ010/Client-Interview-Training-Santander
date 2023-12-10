package com.coforge.circuit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Error {

    private int httpCode;
    private String httpMessage;
    private String additionalInformation;
}
