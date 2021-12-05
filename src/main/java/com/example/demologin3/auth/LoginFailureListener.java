package com.example.demologin3.auth;

import com.example.demologin3.data.ResponseDataCode;
import com.example.demologin3.data.ResponseDataStatus;
import com.example.demologin3.dto.ResponseDataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class LoginFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    Logger logger = LoggerFactory.getLogger(LoginFailureListener.class);

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        String username = (String)event.getAuthentication().getPrincipal();
        String password = (String)event.getAuthentication().getCredentials();
        logger.info("접속실패 : " + username + " / " + password);
    }
}
