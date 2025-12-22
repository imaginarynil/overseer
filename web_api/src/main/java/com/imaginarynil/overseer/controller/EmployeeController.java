package com.imaginarynil.overseer.controller;

import com.imaginarynil.overseer.dto.EmployeeRequest;
import com.imaginarynil.overseer.model.Employee;
import com.imaginarynil.overseer.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public void createEmployee(@RequestBody EmployeeRequest request) {
        this.employeeService.createEmployee(request.toModel());
    }

    @GetMapping("/employee")
    public Iterable<Employee> findAll(@RequestBody EmployeeRequest request) {
        return this.employeeService.findAll();
    }
}
