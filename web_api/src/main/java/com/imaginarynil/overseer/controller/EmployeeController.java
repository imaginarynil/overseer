package com.imaginarynil.overseer.controller;

import com.imaginarynil.overseer.dto.EmployeeLocationRequest;
import com.imaginarynil.overseer.dto.EmployeeRequest;
import com.imaginarynil.overseer.model.Employee;
import com.imaginarynil.overseer.model.EmployeeLocation;
import com.imaginarynil.overseer.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public void create(@RequestBody EmployeeRequest request) {
        this.employeeService.save(request.toModel());
    }

    @GetMapping("/employee")
    public Iterable<Employee> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable long id) {
        return this.employeeService.findById(id);
    }

    @GetMapping("/employee/{id}/location")
    public EmployeeLocationRequest findLocationById(@PathVariable long id) {
        EmployeeLocation employee = this.employeeService.findLocationById(id);
        return new EmployeeLocationRequest(employee.getLatitude(), employee.getLongitude());
    }
}
