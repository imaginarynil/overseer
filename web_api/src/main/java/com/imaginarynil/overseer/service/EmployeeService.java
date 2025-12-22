package com.imaginarynil.overseer.service;

import com.imaginarynil.overseer.model.Employee;
import com.imaginarynil.overseer.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    public Iterable<Employee> findAll() {
        return this.employeeRepository.findAll();
    }
}
