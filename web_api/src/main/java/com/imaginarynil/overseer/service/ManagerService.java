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

    public void delete(Long managerId) {
        Manager manager = this.managerRepository.findById(managerId).orElseThrow(ManagerNotFoundException::new);
        this.managerRepository.delete(manager);
    }

    public void update(Long managerId, Manager request) {
        Manager manager = this.managerRepository.findById(managerId).orElseThrow(ManagerNotFoundException::new);
        manager.setName(request.getName());
        manager.setUsername(request.getUsername());
        manager.setPhoneNumber(request.getPhoneNumber());
        this.managerRepository.save(manager);
    }
}
