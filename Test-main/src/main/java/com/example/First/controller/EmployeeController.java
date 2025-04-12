//package com.example.First.controller;
//
//import com.example.First.entity.Employee;
//import com.example.First.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import jakarta.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/employees")
//public class EmployeeController {
//
//    private final EmployeeService employeeService;
//
//    @Autowired
//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    // Create employee in specific department
//    @PostMapping("/{departmentId}")
//    public ResponseEntity<Employee> createEmployee(
//            @PathVariable Long departmentId,
//            @Valid @RequestBody Employee employee
//    ) {
//        Employee createdEmployee = employeeService.createEmployee(departmentId, employee);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .header("Location", "/api/employees/" + createdEmployee.getId())
//                .body(createdEmployee);
//    }
//
//    // Get all employees
//    @GetMapping
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        List<Employee> employees = employeeService.getAllEmployees();
//        return ResponseEntity.ok(employees);
//    }
//
//    // Get employee by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        return employeeService.getEmployeeById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Update employee
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> updateEmployee(
//            @PathVariable Long id,
//            @Valid @RequestBody Employee employeeDetails
//    ) {
//        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDetails));
//    }
//
//    // Delete employee
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // Get employees by designation
//    @GetMapping("/designation/{designation}")
//    public ResponseEntity<List<Employee>> getEmployeesByDesignation(
//            @PathVariable String designation
//    ) {
//        List<Employee> employees = employeeService.getEmployeesByDesignation(designation);
//        return employees.isEmpty() ?
//                ResponseEntity.noContent().build() :
//                ResponseEntity.ok(employees);
//    }
//
//    // Get employees by department
//    @GetMapping("/department/{departmentId}")
//    public ResponseEntity<List<Employee>> getEmployeesByDepartment(
//            @PathVariable Long departmentId
//    ) {
//        List<Employee> employees = employeeService.getEmployeesByDepartment(departmentId);
//        return employees.isEmpty() ?
//                ResponseEntity.noContent().build() :
//                ResponseEntity.ok(employees);
//    }
//}