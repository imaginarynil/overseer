package com.imaginarynil.overseer.controller;

import com.imaginarynil.overseer.model.Employee;
import com.imaginarynil.overseer.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @PostMapping
    public void create(@RequestBody Employee employee) {
        this.employeeRepository.save(employee);
    }

//    @PostMapping
//    public void create(@RequestBody Employee employee) {
//        this.employeeService.save(employee);
//    }
//
//    @GetMapping
//    public List<Employee> findAll() {
//        return this.employeeService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> findById(@PathVariable long id) {
//        Employee employee = this.employeeService.findById(id);
//        if (employee == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(employee);
//    }
//
//    @GetMapping("/{id}/location")
//    public EmployeeLocation findLocationById(@PathVariable long id) {
//        return this.employeeService.findLocationById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable long id) {
//        this.employeeService.deleteById(id);
//    }
}
