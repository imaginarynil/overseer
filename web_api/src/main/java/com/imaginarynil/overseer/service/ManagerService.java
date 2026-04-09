package com.imaginarynil.overseer.service;

import com.imaginarynil.overseer.exception.ManagerNotFoundException;
import com.imaginarynil.overseer.model.Manager;
import com.imaginarynil.overseer.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerService {
    private final ManagerRepository managerRepository;

    public List<Manager> findAll() {
        return this.managerRepository.findAll();
    }

    public Manager findById(Long managerId) {
        return this.managerRepository.findById(managerId).orElseThrow(ManagerNotFoundException::new);
    }

    public void save(Manager manager) {
        this.managerRepository.save(manager);
    }

//    public void update(Manager manager) {
//        Manager newManager = this.managerRepository.findById(manager.getId()).orElseThrow(ManagerNotFoundException::new);
//    }
}
