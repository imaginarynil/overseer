package com.imaginarynil.overseer.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Employee {
    @Id
    private long id;
    private final long managerId;
    private final String name;
    private final String username;
    private final String password;
    private final String phoneNumber;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public Employee(long managerId, String name, String username, String password, String phoneNumber) {
        this.managerId = managerId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getManagerId() {
        return managerId;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}