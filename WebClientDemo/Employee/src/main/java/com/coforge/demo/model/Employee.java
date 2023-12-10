package com.coforge.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {

@Id
private int EMP_Id;
private String firstname;
private String lastname;
private String dept;
private int age;
private int salary;


}
