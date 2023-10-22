package com.example.demo.Association.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Data
@Table(name = "Project")
public class Project {

    @Id
    private int id;
    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

}
