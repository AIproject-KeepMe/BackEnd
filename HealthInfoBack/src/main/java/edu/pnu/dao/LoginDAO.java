package edu.pnu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.LoginVO;

@Repository
public class LoginDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public LoginVO getMember(String id) {
	    String sql = "select adminId, password from admin where adminId = ?";
	    RowMapper<LoginVO> rowMapper = new BeanPropertyRowMapper<>(LoginVO.class);
	    return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
}