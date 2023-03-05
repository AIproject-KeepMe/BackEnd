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
	
	// 중복확인용 메서드.
	// list가 null이 아니면, 그러니까 아이디가 중복이면 true, 중복이 아니면 false
    public boolean checkId(String id) {
        LoginVO loginVO = loginDAO.getMember(id);
        return loginVO != null;
    }
	
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
	
		// 세션 ID 비교 메서드
		public boolean checkSessionId(HttpServletRequest request) {
			// 세션의 Attribute를 get해서 세션 id가 일치하면 true
			HttpSession session = request.getSession();
			String sessionId = (String) session.getAttribute("sessionId");
			LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
			
			if (sessionId != null && loginVO != null && sessionId.equals(loginVO.getSessionId())) {
				return true;
			} else {
				return false;
			}
		}
}
