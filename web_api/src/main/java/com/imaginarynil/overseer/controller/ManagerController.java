package com.imaginarynil.overseer.controller;

import com.imaginarynil.overseer.model.Manager;
import com.imaginarynil.overseer.repository.ManagerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    private final ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping
    public List<Manager> findAll() {
        return this.managerRepository.findAll();
    }

    @PostMapping
    public void create(@RequestBody Manager manager) {
        this.managerRepository.save(manager);
    }
}
