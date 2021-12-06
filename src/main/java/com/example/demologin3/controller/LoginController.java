package com.example.demologin3.controller;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping("/login")
//    public String Login(@RequestParam HttpServletRequest request, HttpServletResponse response) {
    public String Login() {
        /*RequestCache requestCache = new HttpSessionRequestCache();
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        try {
            //여러가지 이유로 이전페이지 정보가 없는 경우가 있음.
            //https://stackoverflow.com/questions/6880659/in-what-cases-will-http-referer-be-empty
            request.getSession().setAttribute("prevPage", savedRequest.getRedirectUrl());
        } catch(NullPointerException e) {
            request.getSession().setAttribute("prevPage", "/");
        }*/
        return "login";
    }
}
