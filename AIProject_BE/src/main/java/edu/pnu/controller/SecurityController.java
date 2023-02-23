package edu.pnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {


	@GetMapping("/member")
	public void forMember() {
		System.out.println("member 요청임");
	}
	
	@GetMapping("/manager")
	public void forManager() {
		System.out.println("manager 요청임");
	}
	
	@GetMapping("/admin")
	public void forAdmin() {
		System.out.println("admin 요청임");
	}
	
	@GetMapping("/templogin")
	public void login() {
	}

	@GetMapping("/loginSuccess")
	public void loginSuccess() {
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
		
	}
}
