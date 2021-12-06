package com.example.demologin3.controller;

import com.example.demologin3.auth.PrincipalDetails;
import com.example.demologin3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView modelAndView, @AuthenticationPrincipal PrincipalDetails principalDetails) {
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
        modelAndView.setViewName("admin");
        return modelAndView;
    }
}
