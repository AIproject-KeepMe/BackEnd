package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.TestDAO;
import edu.pnu.domain.TestVO;

@Service
public class TestService {
	
	@Autowired
	TestDAO td;
	
	public List<TestVO> test() {
		return td.test();
	}
}
