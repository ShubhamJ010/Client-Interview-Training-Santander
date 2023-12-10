package com.coforge.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Address {
 @Id
 private int empId;
 private String address1;
 private int zipcode;
 private String city;
 private String country;
 
}
