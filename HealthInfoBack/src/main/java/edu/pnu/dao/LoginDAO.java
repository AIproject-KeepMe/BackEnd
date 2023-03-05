package edu.pnu.dao;

import java.util.List;

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
	
	// 쿼리를 날려서 id가 있는지 없는지 조회하는데, 반환된 list가 empty면 null, 아니면 id 반환
	public LoginVO getMember(String id) {
        String sql = "select adminId, password from admin where adminId = ?";
        RowMapper<LoginVO> rowMapper = new BeanPropertyRowMapper<>(LoginVO.class);
        List<LoginVO> list = jdbcTemplate.query(sql, rowMapper, id);
        return list.isEmpty() ? null : list.get(0);
    }
}