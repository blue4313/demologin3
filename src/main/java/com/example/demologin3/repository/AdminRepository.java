package com.example.demologin3.repository;

import com.example.demologin3.dto.AdminDTO;
import com.example.demologin3.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByAdminId(String adminId);
//    AdminDTO findByAdminId(String adminId);
}
