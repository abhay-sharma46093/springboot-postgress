package com.infostride.springbootpostgress.model;

import java.util.List;

public class AllEmployeeResponse {

    private List<Employee> employees;
    private String message;
    private int code = 200;

    public AllEmployeeResponse() {

    }

    public AllEmployeeResponse(List<Employee> employees, String message, int code) {
        this.employees = employees;
        this.message = message;
        this.code = code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
