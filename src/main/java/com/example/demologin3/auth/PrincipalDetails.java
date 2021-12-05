package com.example.demologin3.auth;

import com.example.demologin3.entity.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private Admin admin;

    public PrincipalDetails(Admin admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return admin.getAdminRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return admin.getAdminPw();
    }

    @Override
    public String getUsername() {
        return admin.getAdminId();
    }

    public String getAdminName() {
        return admin.getAdminName();
    }

    public String getAdminEmail() {
        return admin.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
