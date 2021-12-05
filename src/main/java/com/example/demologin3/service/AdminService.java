package com.example.demologin3.service;

import com.example.demologin3.entity.Admin;
import com.example.demologin3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin findByAdminId(String adminId) {
        return adminRepository.findByAdminId(adminId);
    }
}
