package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.UserVO;
import edu.pnu.domain.UsersVO;

@Repository
public class LeftsideDAO {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public List<UserVO> getUserList() {
		String sql = "select * from user";
		List<UserVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserVO>(UserVO.class));
		return list;
	}

	public List<UsersVO> getUsersList() {
		String sql = "select * from user2";
		List<UsersVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UsersVO>(UsersVO.class));
		return list;
	}

}
