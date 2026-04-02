package com.imaginarynil.overseer.repository;


import com.imaginarynil.overseer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
