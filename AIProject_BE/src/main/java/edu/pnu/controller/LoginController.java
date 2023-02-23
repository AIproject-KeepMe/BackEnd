package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class LoginController {

	@Autowired
	public MemberService ms;
	
    @GetMapping("/login")
    public List<MemberVO> getMember(@RequestParam String id, @RequestParam String password) {
        return ms.getMember(id, password);
    }
}
