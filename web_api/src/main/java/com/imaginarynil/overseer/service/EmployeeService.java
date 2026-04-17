package com.imaginarynil.overseer.service;

import com.imaginarynil.overseer.exception.EmployeeNotFoundException;
import com.imaginarynil.overseer.model.Employee;
import com.imaginarynil.overseer.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    public Employee findById(Long employeeId) {
        return this.employeeRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }

    public void create(Employee employee) {
        this.employeeRepository.save(employee);
    }
}
