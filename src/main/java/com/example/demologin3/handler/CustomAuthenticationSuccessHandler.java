package com.example.demologin3.handler;

import com.example.demologin3.data.ResponseDataCode;
import com.example.demologin3.data.ResponseDataStatus;
import com.example.demologin3.dto.ResponseDataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 로그인 성공시 핸들러
 *
 */
@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /**
     * 로그인이 성공하고나서 로직
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        System.out.println("로그인 성공 ㅎㅎㅎㅎ");

        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print("<script>alert('로그인 성공 ㅎㅎㅎㅎ');location.href='/';</script>");
        response.getWriter().flush();

        /*ObjectMapper mapper = new ObjectMapper();	//JSON 변경용

        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setCode(ResponseDataCode.SUCCESS);
        responseDataDTO.setStatus(ResponseDataStatus.SUCCESS);

        String prevPage = request.getSession().getAttribute("prevPage").toString();	//이전 페이지 가져오기

        Map<String, String> items = new HashMap<String,String>();
        items.put("url", prevPage);	// 이전 페이지 저장
        responseDataDTO.setItem(items);

        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(mapper.writeValueAsString(responseDataDTO));
        response.getWriter().flush();*/
    }
}
