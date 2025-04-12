package com.example.First.service;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.First.entity.Department;
import com.example.First.entity.Employee;
import com.example.First.repository.DepartmentRepository;
import com.example.First.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public Employee createEmployee(Long departmentId, Employee employee) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // New method to get employees by designation
    public List<Employee> getEmployeesByDesignation(String designation) {
        return employeeRepository.findByDesignation(designation);
    }

    // Additional improvement: Get employees by department
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    // Optional: Combined search
    public List<Employee> searchEmployees(String designation, Long departmentId) {
        if(departmentId != null && designation != null) {
            return employeeRepository.findByDesignationAndDepartmentId(designation, departmentId);
        } else if(departmentId != null) {
            return getEmployeesByDepartment(departmentId);
        } else if(designation != null) {
            return getEmployeesByDesignation(designation);
        }
        return getAllEmployees();
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        return employeeDetails;
    }

   
    public void deleteEmployee(Long id) {
    }

    public Remapper getEmployeeById(Long id) {
        return null;
    }
}