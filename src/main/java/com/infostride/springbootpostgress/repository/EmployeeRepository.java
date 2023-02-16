package com.infostride.springbootpostgress.repository;

import com.infostride.springbootpostgress.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM employees WHERE first_name = ?1", nativeQuery = true)
    public Employee findByFirstName(String name);

    @Query(value = "SELECT e.id,e.email_id,e.first_name,e.last_name,e.emp_grade,s.basic_salary from employees e inner join emp_salary s on e.emp_grade = s.emp_grade where e.emp_grade= ?1", nativeQuery = true)
    public List<Employee> findByGrade(String grade);
}