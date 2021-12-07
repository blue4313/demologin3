package com.example.demologin3.handler;

import com.example.demologin3.data.ResponseDataCode;
import com.example.demologin3.data.ResponseDataStatus;
import com.example.demologin3.dto.ResponseDataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 로그인 실패시 로직
 *
 */
@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        System.out.println("로그인 실패ㅠㅠㅠㅠ");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<script>alert('로그인 실패'); location.href='/login';</script>");

        printWriter.flush();


        /*response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);

        response.getWriter().
        response.getWriter().print("<script>alert('로그인 실패ㅠㅠㅠㅠ');location.href='/login';</script>");
        response.getWriter().flush();*/

        /*ObjectMapper mapper = new ObjectMapper();	//JSON 변경용

        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setCode(ResponseDataCode.ERROR);
        responseDataDTO.setStatus(ResponseDataStatus.ERROR);
        responseDataDTO.setMessage("아이디 혹은 비밀번호가 일치하지 않습니다.");


        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(mapper.writeValueAsString(responseDataDTO));
        response.getWriter().flush();*/

    }
}
