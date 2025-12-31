package com.imaginarynil.overseer.service;

import com.imaginarynil.overseer.exception.ItemNotFoundException;
import com.imaginarynil.overseer.model.Employee;
import com.imaginarynil.overseer.model.EmployeeLocation;
import com.imaginarynil.overseer.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    public Iterable<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    public Employee findById(long id) {
        return this.employeeRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Unable to find employee with id " + id));
    }

    public EmployeeLocation findLocationById(long id) {
        EmployeeLocation employeeLocation = this.employeeRepository.findLocationById(id);
        if (employeeLocation == null) {
            throw new ItemNotFoundException("Unable to find employee with id " + id);
        }
        return employeeLocation;
    }
}
