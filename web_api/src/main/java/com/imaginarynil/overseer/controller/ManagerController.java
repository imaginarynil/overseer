package com.imaginarynil.overseer.controller;

import com.imaginarynil.overseer.exception.ManagerNotFoundException;
import com.imaginarynil.overseer.model.Manager;
import com.imaginarynil.overseer.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/manager")
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping
    public List<Manager> findAll() {
        return this.managerService.findAll();
    }

    @GetMapping("/{managerId}")
    public Manager findById(@PathVariable Long managerId) {
        return this.managerService.findById(managerId);
    }

    @PostMapping
    public void create(@RequestBody Manager manager) {
        this.managerService.save(manager);
    }

    @ExceptionHandler(ManagerNotFoundException.class)
    ResponseEntity<Void> handleManagerNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

//    @PutMapping
//    public void update(@RequestBody Manager manager) {
//        this.managerService.update(manager);
//    }
}
