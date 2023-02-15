package com.infostride.springbootpostgress.repository;

import com.infostride.springbootpostgress.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(
            value = "SELECT * FROM employees WHERE first_name = ?1",
            nativeQuery = true
    )
    public Employee findByFirstName(String name);
}