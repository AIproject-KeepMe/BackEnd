package edu.pnu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.WorkerDAO;
import edu.pnu.domain.WorkerVO;

@Service
public class WorkerService {

	@Autowired
	WorkerDAO wd;
	
	public List<WorkerVO> getWorkerList() {
		return wd.getWorkerList();
	}
	
	 public List<WorkerVO> getWorkerResults() {
	        return wd.getWorkerResults();
	    }
}
