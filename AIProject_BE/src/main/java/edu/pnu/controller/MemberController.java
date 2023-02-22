package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.pnu.domain.MemberVO;
import io.swagger.annotations.Api;

@Controller
@Api(description = "회원가입")
public class MemberController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @PostMapping("/addMember")
    public String addMember(MemberVO memberVO) {
        // INSERT 쿼리문을 작성합니다.
        String sql = "INSERT INTO member (id, password, name, role, enabled) VALUES (?, ?, ?, 'ROLE_MEMBER', 1)";
        
        // INSERT 쿼리문을 실행합니다.
        int result = jdbcTemplate.update(sql, memberVO.getId(), memberVO.getPassword(), memberVO.getName());
		
        if (result > 0) {
            // 삽입이 성공한 경우
            return "redirect:/success";
        } else {
            // 삽입이 실패한 경우
            return "redirect:/error";
        }
    }
    
    @GetMapping("/success")
    public String success() {
        return "success"; // success.html 페이지로 이동
    }
    
    @GetMapping("/error")
    public String error() {
        return "error"; // error.html 페이지로 이동
    }
}