package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.UserVO;

@Repository
public class LeftsideDAO {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public List<UserVO> getUserList() {
		String sql = "select * from user";
		List<UserVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserVO>(UserVO.class));
		return list;
	}

}
