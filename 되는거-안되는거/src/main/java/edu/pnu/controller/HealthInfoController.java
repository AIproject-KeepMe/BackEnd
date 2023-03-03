package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.HealthInfoVO;
import edu.pnu.service.HealthInfoService;

@RestController
public class HealthInfoController {

	private HealthInfoService healthInfoService;
	
	@Autowired
	public HealthInfoController(HealthInfoService healthInfoService) {
		this.healthInfoService = healthInfoService;
	}
	
	// 한 id에 대한 최신 건강 데이터 조회
	@GetMapping("/healthinfo/{id}")
	public HealthInfoVO getHealthInfo(@PathVariable String id) {
		System.out.println("id :" + id);
		return healthInfoService.getHealthInfo(id);
	}
	
	// 한 id에 대해 10개의 데이터 조회
	@GetMapping("/healthinfoTen/{id}")
	public List<HealthInfoVO> getFirstTenHealthInfo(@PathVariable String id) {
	    return healthInfoService.getFirstTenHealthInfo(id);
	}
	
	// 모든 id에 대한 최신 건강 데이터 조회
	@GetMapping("/healthinfo/all")
	public List<HealthInfoVO> getAllHealthInfo() {
		return healthInfoService.getHealthInfoAll();
	}
	
	// 한 id에 대한 최신 건강 데이터를 push
	@GetMapping("/healthpush/{id}")
	public void pushHealthInfo(@PathVariable String id) {
		System.out.println("push_id :" + id);
		 healthInfoService.pushHealthInfo(id);
	}
}
