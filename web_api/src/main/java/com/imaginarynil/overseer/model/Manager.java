package com.imaginarynil.overseer.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    @Column(insertable = false, updatable = false)
    private Date creationDate;
    @OneToMany(mappedBy = "manager") // mappedby is attribute from the owning side
    @JsonManagedReference
    Set<Employee> employees;
}
