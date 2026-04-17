package com.imaginarynil.overseer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private BigDecimal latitude;
    private BigDecimal longitude;
    @Column(insertable = false, updatable = false)
    private LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = true)
    @JsonBackReference
    private Manager manager;
}