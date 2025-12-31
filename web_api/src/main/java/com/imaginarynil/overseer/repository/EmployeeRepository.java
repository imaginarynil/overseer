package com.imaginarynil.overseer.repository;


import com.imaginarynil.overseer.model.Employee;
import com.imaginarynil.overseer.model.EmployeeLocation;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query("SELECT latitude, longitude FROM employee WHERE id = :id")
    EmployeeLocation findLocationById(long id);
}
