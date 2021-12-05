package com.example.demologin3.service;

import com.example.demologin3.entity.Admin;
import com.example.demologin3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {

        System.out.println("loadUserByUsername of adminId >>" + adminId);

        Admin admin = adminService.findByAdminId(adminId);
        return new User(admin.getAdminId(), admin.getAdminPw(), getAuthorities(admin));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Admin admin) {

        System.out.println("GrantedAuthority of adminId >>" + admin);

        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return new Admin().getAdminRole();
            }
        });
        return collect;
    }
}
