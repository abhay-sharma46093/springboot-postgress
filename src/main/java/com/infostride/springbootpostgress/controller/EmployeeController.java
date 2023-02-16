package com.infostride.springbootpostgress.controller;

import com.infostride.springbootpostgress.exception.ResourceNotFoundException;
import com.infostride.springbootpostgress.model.AllEmployeeResponse;
import com.infostride.springbootpostgress.model.Employee;
import com.infostride.springbootpostgress.model.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.infostride.springbootpostgress.repository.EmployeeRepository;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employees
    @GetMapping("/employees")
    public AllEmployeeResponse getAllEmployees() {

        AllEmployeeResponse allEmployeeResponse = new AllEmployeeResponse();
        var empList = employeeRepository.findAll();
        if (empList.isEmpty()){
            allEmployeeResponse.setCode(404);
            allEmployeeResponse.setMessage("Data not found!");
            allEmployeeResponse.setEmployees(new ArrayList<>());
        }else {
            allEmployeeResponse.setCode(200);
            allEmployeeResponse.setMessage("SUCCESS!");
            allEmployeeResponse.setEmployees(empList);
        }


        return allEmployeeResponse;
    }

    // create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        EmployeeResponse employeeResponse = new EmployeeResponse();
        if (employee == null){
            employeeResponse.setMessage("No data found!");
            employeeResponse.setCode(404);
            employeeResponse.setEmployee(null);
        }else {
            employeeResponse.setMessage("SUCCESS!");
            employeeResponse.setCode(200);
            employeeResponse.setEmployee(employee);
        }

        return ResponseEntity.ok(employeeResponse);
    }

    // update employee rest api

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setEmpGrade(employeeDetails.getEmpGrade());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // get employee by name rest api
    @GetMapping("/employees/name/{name}")
    public ResponseEntity<EmployeeResponse> getEmployeeByName(@PathVariable String name) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Employee employee = employeeRepository.findByFirstName(name);
        if (employee == null){
            employeeResponse.setMessage("No data found!");
            employeeResponse.setCode(404);
            employeeResponse.setEmployee(null);
        }else {
            employeeResponse.setMessage("SUCCESS!");
            employeeResponse.setCode(200);
            employeeResponse.setEmployee(employee);
        }

        return ResponseEntity.ok(employeeResponse);
    }

    // get employee by name rest api
    @GetMapping("/employees/salary/{grade}")
    public AllEmployeeResponse getEmployeeWithSalary(@PathVariable String grade) {
        var employee = employeeRepository.findByGrade(grade.toUpperCase(Locale.ROOT));
        AllEmployeeResponse allEmployeeResponse = new AllEmployeeResponse();
        if (employee.isEmpty()){
            allEmployeeResponse.setCode(404);
            allEmployeeResponse.setMessage("Data not found!");
            allEmployeeResponse.setEmployees(new ArrayList<>());
        }else {
            allEmployeeResponse.setCode(200);
            allEmployeeResponse.setMessage("SUCCESS!");
            allEmployeeResponse.setEmployees(employee);
        }
        return allEmployeeResponse;
    }


}