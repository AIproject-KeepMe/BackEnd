package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.WorkerVO;
import edu.pnu.service.WorkerService;

@RestController
public class Controller {

	@Autowired
	WorkerService ws;
	
	@GetMapping("/data/workerlist")
	public List<WorkerVO> getWorkerList() {
		return ws.getWorkerList();
	}

	
	/*
	 * 새로 업데이트도 잘 됨?
	 * 
			*/
	//Test 
}
