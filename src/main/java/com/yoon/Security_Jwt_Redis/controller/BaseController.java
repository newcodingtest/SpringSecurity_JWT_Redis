package com.yoon.Security_Jwt_Redis.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yoon.Security_Jwt_Redis.config.SecurityUser;

@Controller
public class BaseController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/main")
	public String main(Authentication auth, ModelMap map) {
		SecurityUser user =(SecurityUser)auth.getPrincipal();
		map.addAttribute("user",user);
		return "main";
	}
	
	@RequestMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member";
	}
	
	@RequestMapping("/manager")
	public String manager() {
		return "manager";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
}
