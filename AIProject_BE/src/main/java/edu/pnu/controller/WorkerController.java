package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.pnu.domain.WorkerVO;
import edu.pnu.service.WorkerService;
import io.swagger.annotations.Api;

@RestController
@Api(description = "테이블 반환하는지 첫 테스트")
public class WorkerController {

	@Autowired
	WorkerService ws;
	
	@GetMapping("/data/workerlist")
	public List<WorkerVO> getWorkerList() {
		return ws.getWorkerList();
	}

	@GetMapping("/results")
	public List<WorkerVO> getWorkerResults() {
		return ws.getWorkerResults();
	}

	
// 	@GetMapping("/results")
// 	public ModelAndView getWorkerResults() {
// 	    List<WorkerVO> workerResults = ws.getWorkerResults();
// 	    ModelAndView mav = new ModelAndView("results");
// 	    mav.addObject("workerList", workerResults);
// 	    return mav;
// 	}
}
