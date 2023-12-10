package com.coforge.demo.model;

import lombok.Data;

@Data
public class AddressResponse {
    private String address1;
    private int zipcode;
    private String city;
    private String country;

}
