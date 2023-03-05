package com.exam.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Setter
    @Getter
    class Error {
        private String data;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Error error = new Error();
        error.setData("test");

        String result = new ObjectMapper().writeValueAsString(error);
        response.getWriter().println(result);

    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("test");
        super.afterPropertiesSet();
    }
}
