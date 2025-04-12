package com.example.First.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee name is mandatory")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Designation is mandatory")
    private String designation;

    @NotNull(message = "Joining date is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @NotNull(message = "Salary is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Invalid salary format")
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    // Constructors
    public Employee() {}

    public Employee(String name, String designation, LocalDate joiningDate, BigDecimal salary) {
        this.name = name;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.salary = salary;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) {
        this.department = department;
        if(department != null && !department.getEmployees().contains(this)) {
            department.addEmployee(this);
        }
    }
}