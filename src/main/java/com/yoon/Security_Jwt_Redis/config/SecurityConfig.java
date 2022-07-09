package com.yoon.Security_Jwt_Redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//WebMvcConfigurer: JWT 토큰 사용시
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/").permitAll(); //개나소나 다 접근
		http.authorizeHttpRequests().antMatchers("/main").authenticated(); //시큐리티에 의해서 로그인 된 사용자만 접근 가능
		http.authorizeHttpRequests().antMatchers("/member/**").authenticated(); //시큐리티에 의해서 로그인 된 사용자는 member/** 페이지까지 모드 접근 가능
		http.authorizeHttpRequests().antMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN"); // ROLE_MANAGER, ROLE_ADMIN만 /manager/** 페이지에 접근 가능
		http.authorizeHttpRequests().antMatchers("/admin/**").hasAnyRole("ADMIN"); // ROLE_MANAGER, ROLE_ADMIN만 /manager/** 페이지에 접근 가능
		
		http.csrf().disable(); //공식문서 non-browser clients 만을 위한 서비스라면 csrf를 disable 하여도 좋다고 함. 추후 rest api 인증 처리를 위함=> 서버에 인증 정보를 저장해두지 않음
		
		//http.formLogin().loginPage("/login").defaultSuccessUrl("/main",true); //로그인 성공했을 시 페이지 지정
		http.formLogin().defaultSuccessUrl("/main",true); //로그인 성공했을 시 페이지 지정
		http.formLogin().successHandler(successHandler()).defaultSuccessUrl("/main",true); //로그인 시도(POST)시 "/loginAction" url로 이동, 성공시 "/main" url로 이동
		http.exceptionHandling().accessDeniedPage("/accessDenied"); // 권한 없을때 접근시 이동 페이지 설정
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/"); // 로구어윳 url 설정
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	   @Bean
	    public ClubLoginSuccessHandler successHandler(){
	        return new ClubLoginSuccessHandler(passwordEncoder());
	    }

}
