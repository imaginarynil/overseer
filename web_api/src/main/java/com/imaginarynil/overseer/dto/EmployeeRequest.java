package com.imaginarynil.overseer.dto;

import com.imaginarynil.overseer.model.Employee;

public class EmployeeRequest {
    private long managerId;
    private String name;
    private String username;
    private String password;
    private String phoneNumber;

    public Employee toModel() {
        return new Employee(this.managerId, this.name, this.username, this.password, this.phoneNumber);
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
