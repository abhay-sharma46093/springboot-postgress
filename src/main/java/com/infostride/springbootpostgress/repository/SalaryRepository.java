package com.infostride.springbootpostgress.repository;

import com.infostride.springbootpostgress.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    @Query(value = "SELECT * FROM emp_salary WHERE emp_grade = ?1", nativeQuery = true)
    public Salary findByEmpGrade(String grade);
}