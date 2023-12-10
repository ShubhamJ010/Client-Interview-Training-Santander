package com.coforge.addres2.model;

import lombok.Data;

@Data
public class AddressResponse {
    private int empId;
    private String address1;
    private int zipcode;
    private String city;
    private String country;

}
