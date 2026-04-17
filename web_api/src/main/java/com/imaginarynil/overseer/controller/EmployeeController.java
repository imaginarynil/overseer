package com.imaginarynil.overseer.controller;

import com.imaginarynil.overseer.common.ErrorDto;
import com.imaginarynil.overseer.exception.EmployeeNotFoundException;
import com.imaginarynil.overseer.model.Employee;
import com.imaginarynil.overseer.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee findById(@PathVariable Long employeeId) {
        return this.employeeService.findById(employeeId);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDto> handleEmployeeNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Employee not found"));
    }

//    @GetMapping("/{id}/location")
//    public EmployeeLocation findLocationById(@PathVariable long id) {
//        return this.employeeService.findLocationById(id);
//    }
}
