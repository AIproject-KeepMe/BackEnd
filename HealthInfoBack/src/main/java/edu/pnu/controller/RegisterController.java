package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.RegisterVO;

@RestController
public class RegisterController {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@PostMapping("/addMember")
	public void addMember(RegisterVO registerVO) {
		String sql = "insert into admin (adminId, password, name, contact, position, email) values (?, ?, ?, ?, ?, ?)";
		try {
			jdbcTemplate.update(sql, registerVO.getAdminId(), registerVO.getPassword(), registerVO.getName(), registerVO.getContact(), registerVO.getPosition(), registerVO.getEmail());
			System.out.println("들어갔음");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
