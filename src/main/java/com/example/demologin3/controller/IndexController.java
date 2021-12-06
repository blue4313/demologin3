package com.example.demologin3.controller;

import com.example.demologin3.auth.PrincipalDetails;
import com.example.demologin3.entity.Admin;
import com.example.demologin3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.ZonedDateTime;

@Controller
public class IndexController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView, @AuthenticationPrincipal PrincipalDetails principalDetails) {

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserDetails userDetails = (UserDetails)principal;
//        String username = ((UserDetails) principal).getUsername();
//        String password = ((UserDetails) principal).getPassword();

//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        System.out.println(userDetails.getUsername());

//        System.out.println(admin.getAdminId());

//        model.addAttribute("username", username);

        boolean isLogin = false;

        if (principalDetails != null) {
            System.out.println(principalDetails.getUsername());
            System.out.println(principalDetails.getAdminName());
            System.out.println(principalDetails.getAdminEmail());

            isLogin = true;

        } else {

        }

        modelAndView.addObject("username", "22222");
        modelAndView.addObject("isLogin", isLogin);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/joinOK")
    public String joinOK(Admin admin) {
        System.out.println(admin);

        admin.setAdminPw(passwordEncoder.encode(admin.getAdminPw()));
        admin.setAdminRole("ROLE_ADMIN");
        admin.setRegDate(ZonedDateTime.now());
        adminRepository.save(admin);

        return "joinOK";
    }
}
