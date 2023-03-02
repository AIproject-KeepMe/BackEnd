package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.UserVO;
import edu.pnu.domain.UsersVO;
import edu.pnu.service.LeftsideService;

@RestController
public class LeftsideController {

	@Autowired
	LeftsideService ls;
	
	@GetMapping("/user")
	public List<UserVO> getUserList() {
		return ls.getUserList();
	}
	
	@GetMapping("/users")
	public List<UsersVO> getUsersList() {
		return ls.getUsersList();
	}
}
