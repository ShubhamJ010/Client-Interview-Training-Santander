package com.example.demo.Association.Controller;

import com.example.demo.Association.Repository.DepartmentDao;
import com.example.demo.Association.Repository.EmployeeDao;
import com.example.demo.Association.model.Project;
import com.example.demo.Association.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
public class AssociationController {

    private static int count=0;
    private static int departmentCount=0;

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;



    @GetMapping("/many-to-many-create")
    public void createManyToMany() {

        Project project1=new Project();
        Project project2=new Project();
        Employee employee1=new Employee();
        Employee employee2=new Employee();
        Employee employee3=new Employee();

        employee1.setId(1);
        employee1.setName("Shubham");
        employee2.setId(2);
        employee2.setName("Nicole");
        employee3.setId(3);
        employee3.setName("Ann");

        project1.setId(1);
        project1.setName("niehle");
        project2.setId(2);
        project2.setName("shoune");

        employee1.getProjects().add(project1);
        employee2.getProjects().add(project2);
        employee3.getProjects().add(project2);

        project1.getEmployees().add(employee1);
        project2.getEmployees().add(employee2);
        project2.getEmployees().add(employee3);

        departmentDao.save(project1);
        departmentDao.save(project2);

        System.out.println("many-to-many Employee/Project object created");
    }
}
