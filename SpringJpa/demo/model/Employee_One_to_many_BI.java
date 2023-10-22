package com.example.demo.Association.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Employee_one_to_many_bi")
public class Employee_One_to_many_BI {

    @Id
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="Peice of shit")
    private Department_One_to_many_BI department;



}
