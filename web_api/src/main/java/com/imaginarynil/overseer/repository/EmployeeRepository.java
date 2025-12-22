package com.imaginarynil.overseer.repository;


import com.imaginarynil.overseer.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
