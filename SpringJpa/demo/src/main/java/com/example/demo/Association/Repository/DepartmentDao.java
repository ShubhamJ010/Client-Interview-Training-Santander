package com.example.demo.Association.Repository;

import com.example.demo.Association.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Project,Integer> {
}
