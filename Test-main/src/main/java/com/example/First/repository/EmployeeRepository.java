package com.example.First.repository;

import com.example.First.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDesignation(String designation);

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByDesignationAndDepartmentId(String designation, Long departmentId);
}