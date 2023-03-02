package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LeftsideDAO;
import edu.pnu.domain.UserVO;
import edu.pnu.domain.UsersVO;

@Service
public class LeftsideService {

	@Autowired
	LeftsideDAO ld;
	
	public List<UserVO> getUserList() {
		return ld.getUserList();
	}

	public List<UsersVO> getUsersList() {
		return ld.getUsersList();
	}

}
