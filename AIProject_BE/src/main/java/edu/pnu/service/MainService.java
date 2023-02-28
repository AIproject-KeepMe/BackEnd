package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MainDAO;
import edu.pnu.domain.GpsVO;
import edu.pnu.domain.TestVO;
import edu.pnu.domain.VitalsignVO;

@Service
public class MainService {
	
	@Autowired
	MainDAO td;
	
	public List<TestVO> test() {
		return td.test();
	}

	public List<VitalsignVO> vitalsign() {
		return td.vitalsign();
	}

	public List<GpsVO> gps() {
		return td.gps();
	}
}
