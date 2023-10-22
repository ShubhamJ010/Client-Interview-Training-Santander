package com.example.demo.Association.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Data
@Table(name = "Employee")
public class Employee {

    @Id
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "employees")
    private List<Project> projects=new ArrayList<>();

}
