package edu.pnu.dao;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;
import edu.pnu.domain.MemberVO;


@Component
public class MemberDAO {

    private final JdbcTemplate jdbcTemplate;

    public MemberDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MemberVO> getMember(String id, String password) {
        String sql = "SELECT * FROM member WHERE id = ? AND password = ?";
        RowMapper<MemberVO> rowMapper = new BeanPropertyRowMapper<>(MemberVO.class);
        return jdbcTemplate.query(sql, rowMapper, id, password);
    }


}
