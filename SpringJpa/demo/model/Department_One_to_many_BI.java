package com.example.demo.Association.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Department_one_to_many_bi")
public class Department_One_to_many_BI {

    @Id
    private int id;
    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee_One_to_many_BI> employeeOneToManyBis = new ArrayList<>();

}
