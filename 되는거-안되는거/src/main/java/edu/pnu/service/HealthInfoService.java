package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.pnu.config.HealthWebSocketConfig;
import edu.pnu.dao.HealthInfoDAO;
import edu.pnu.domain.HealthInfoVO;

@Service
public class HealthInfoService {

	@Autowired
	HealthInfoDAO healthInfoDAO;
	
	@Autowired
	HealthWebSocketConfig healthWebSocketConfig;

	// DAO에서 sql 날리기 전에 거치려고 만든 메서드.
	public HealthInfoVO getHealthInfo(String id) {
		return healthInfoDAO.getHealthInfo(id);
	}
	

	public List<HealthInfoVO> getFirstTenHealthInfo(String id) {
		return healthInfoDAO.getFirstTenHealthInfo(id);
	}

	public List<HealthInfoVO> getHealthInfoAll() {
		return healthInfoDAO.getHealthInfoAll();
	}

	public void pushHealthInfo(String id) {
		// 특정 id에 대한 건강 정보 레코드를 push한다.
		// 데이터 읽기
		HealthInfoVO hiv = healthInfoDAO.getHealthInfo(id);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String msg;
		try {
			msg = mapper.writeValueAsString(hiv);
			healthWebSocketConfig.pushService(msg);
		} catch (Exception e) {
			msg = "error:" + e.getMessage();
		}
	}


}
