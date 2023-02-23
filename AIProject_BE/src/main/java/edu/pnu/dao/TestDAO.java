package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.TestVO;

@Repository
public class TestDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TestVO> test() {
		String sql = "select * from test";
		List<TestVO> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<TestVO>(TestVO.class));
		return list;

	}

}
