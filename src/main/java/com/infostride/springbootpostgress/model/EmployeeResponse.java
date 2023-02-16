package com.infostride.springbootpostgress.model;

public class EmployeeResponse {
    private Employee employee;
    private String message;
    private int code = 200;
    public EmployeeResponse(){

    }
    public EmployeeResponse(Employee employee, String message, int code) {
        this.employee = employee;
        this.message = message;
        this.code = code;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
