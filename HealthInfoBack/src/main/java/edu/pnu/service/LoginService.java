package edu.pnu.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LoginDAO;
import edu.pnu.domain.LoginVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	// id를 받아와서 response에서 세션 ID 저장
	public LoginVO getMember(String id, HttpServletRequest request) {
	    LoginVO loginVO = loginDAO.getMember(id);
	    
	    // HttpSession 객체를 가져옴.
	    HttpSession session = request.getSession();
	    
	    // 세션 ID를 랜덤하게 만들고 HttpSession 객체에 저장.
	    String sessionId = UUID.randomUUID().toString();
	    session.setAttribute("sessionId", sessionId);
	    return loginVO;
	}
}