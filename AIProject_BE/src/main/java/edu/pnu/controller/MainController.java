package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.pnu.domain.GpsVO;
import edu.pnu.domain.TestVO;
import edu.pnu.domain.VitalsignVO;
import edu.pnu.service.MainService;

@Controller
public class MainController {

	@Autowired
	MainService ts;

	/*
	 * 리액트 코드를 살펴보면 일단 /test에 들어와서 테이블을 긁도록 하고 있다.
	 * 그래서 그 긁은 게 어디 쓰이나 봤더니 테스트라기보다는 dashboard 오른쪽에서 쓰이고 있음
	 * */
	
	@GetMapping("/test")
	public ResponseEntity<List<TestVO>> test() {
		List<TestVO> testList = ts.test();
		return new ResponseEntity<>(testList, HttpStatus.OK);
	}
	
	@GetMapping("/vitalsign")
	public ResponseEntity<List<VitalsignVO>> vitalsign() {
		List<VitalsignVO> vitalsignList = ts.vitalsign();
		return new ResponseEntity<>(vitalsignList, HttpStatus.OK);
	}
	
	@GetMapping("/gps")
	public ResponseEntity<List<GpsVO>> gps() {
		List<GpsVO> gpsList = ts.gps();
		return new ResponseEntity<>(gpsList, HttpStatus.OK);
	}
}
