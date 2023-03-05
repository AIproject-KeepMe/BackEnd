package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.LoginVO;
import edu.pnu.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public LoginVO getMember(@RequestParam String id, HttpServletRequest request) {
	    System.out.println(id);
		return loginService.getMember(id, request);
	}
	
    @GetMapping("/checkId")
    public boolean checkId(@RequestParam String id) {
        return loginService.checkId(id);
    }
	
	@PostMapping("/logout")
	public void logout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }
	}
}
