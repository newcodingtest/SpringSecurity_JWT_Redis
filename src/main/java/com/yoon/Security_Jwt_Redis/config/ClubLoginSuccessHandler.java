package com.yoon.Security_Jwt_Redis.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClubLoginSuccessHandler implements AuthenticationSuccessHandler {


    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy(); //리다이렉트 클래스

    private PasswordEncoder passwordEncoder;

    public ClubLoginSuccessHandler(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("----------------------------------------------");
        log.info("onAuthenticationSuccess ");

        SecurityUser authMember = (SecurityUser)authentication.getPrincipal();

        boolean fromSocial = authMember.getMember().isEnabled();

        log.info("Need Modify Member?" + fromSocial);
        log.info("비밀번호: "+  passwordEncoder.encode(authMember.getPassword()));

        boolean passwordResult = passwordEncoder.matches("admin", passwordEncoder.encode(authMember.getPassword()));

        if(passwordResult){
            redirectStrategy.sendRedirect(request, response, "/main");
        }
		
	}

}
