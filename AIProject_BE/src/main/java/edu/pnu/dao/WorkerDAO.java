package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.WorkerVO;

@Repository
public class WorkerDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<WorkerVO> getWorkerList() {
		String sql = "select * from result";
		List<WorkerVO> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<WorkerVO>(WorkerVO.class));
		
		return list;

	}
}
