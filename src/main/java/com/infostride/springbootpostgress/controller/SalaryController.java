package com.infostride.springbootpostgress.controller;

import com.infostride.springbootpostgress.model.Employee;
import com.infostride.springbootpostgress.model.Salary;
import com.infostride.springbootpostgress.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/api/v1/emp/")
public class SalaryController {

    @Autowired
    private SalaryRepository salaryRepository;

    // get all salary rest api
    @GetMapping("/salary")
    public List<Salary> getAllEmployees() {
        return salaryRepository.findAll();
    }

    // create employee salary rest api
    @PostMapping("/salary")
    public Salary createEmployeeSalary(@RequestBody Salary salary) {
        return salaryRepository.save(salary);
    }

    // get employee salary by grade rest api
    @GetMapping("/salary/{grade}")
    public Salary updateEmployeeSalaryByGrade(@PathVariable String grade) {
        return salaryRepository.findByEmpGrade(grade.toUpperCase(Locale.ROOT));
    }

}
