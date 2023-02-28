package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LeftsideDAO;
import edu.pnu.domain.UserVO;

@Service
public class LeftsideService {

	@Autowired
	LeftsideDAO ud;
	
	public List<UserVO> getUserList() {
		return ud.getUserList();
	}

}
