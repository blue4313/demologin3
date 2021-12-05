package com.example.demologin3.auth;

import com.example.demologin3.entity.Admin;
import com.example.demologin3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {
        System.out.println("adminId : " + adminId);

        Admin admin = adminRepository.findByAdminId(adminId);

        if (admin == null) {
            throw new UsernameNotFoundException(adminId);
        } else {
//            return new PrincipalDetails(admin);
            return new PrincipalDetails(admin);
        }
    }
}
