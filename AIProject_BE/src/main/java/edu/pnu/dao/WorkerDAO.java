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
	
	public List<WorkerVO> getWorkerResults() {
	    String sql = "SELECT r.user, r.recorded_time FROM result r\r\n"
	    		+ "            INNER JOIN result r2 ON r.user = r2.user \r\n"
	    		+ "            AND r.stat_label = 'falling'\r\n"
	    		+ "            AND r2.stat_label = 'falling'\r\n"
	    		+ "            AND r.recorded_time <> r2.recorded_time\r\n"
	    		+ "            AND ABS(TIMESTAMPDIFF(SECOND, r.recorded_time, r2.recorded_time)) < 60\r\n"
	    		+ "            AND r.id < r2.id";
	    List<WorkerVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WorkerVO.class));
	    return list;
	}
}
