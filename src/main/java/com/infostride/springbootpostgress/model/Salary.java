package com.infostride.springbootpostgress.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emp_salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long s_id;

    @Column(name = "emp_grade")
    private String empGrade;

    @Column(name = "basic_salary")
    private String basicSalary;

    public long getId() {
        return s_id;
    }

    public void setId(long s_id) {
        this.s_id = s_id;
    }

    public String getEmpGrade() {
        return empGrade;
    }

    public void setEmpGrade(String empGrade) {
        this.empGrade = empGrade;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }
}
