package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.pnu.domain.TestVO;
import edu.pnu.service.TestService;
import io.swagger.annotations.Api;

@Controller
@Api(description = "그냥 인덱스만 해 주는거")
public class MainController {

	@Autowired
	TestService ts;

	/*
	 * 리액트 코드를 살펴보면 일단 /test에 들어와서 테이블을 긁도록 하고 있다.
	 * 그래서 그 긁은 게 어디 쓰이나 봤더니 테스트라기보다는 dashboard 오른쪽에서 쓰이고 있음
	 * */
	
	@GetMapping("/test")
	public ResponseEntity<List<TestVO>> test() {
		List<TestVO> testList = ts.test();
		return new ResponseEntity<>(testList, HttpStatus.OK);
	}

}
