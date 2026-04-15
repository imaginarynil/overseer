package com.imaginarynil.overseer.repository;


import com.imaginarynil.overseer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Modifying
    @NativeQuery("UPDATE employee SET manager_id = NULL WHERE manager_id = :managerId")
    void updateManagerOfEmployeesToNull(@Param("managerId") Long managerId);

    @Modifying
    @NativeQuery("UPDATE employee SET manager_id = :managerId WHERE id = :employeeId")
    void addEmployeeToManager(@Param("managerId") Long managerId, @Param("employeeId") Long employeeId);
}
