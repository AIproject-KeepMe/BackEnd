package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.GpsVO;
import edu.pnu.domain.TestVO;
import edu.pnu.domain.VitalsignVO;

@Repository
public class MainDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TestVO> test() {
		String sql = "select * from test";
		List<TestVO> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<TestVO>(TestVO.class));
		return list;
	}

	public List<VitalsignVO> vitalsign() {
		String sql = "select u.id, u.name, u.age, ROUND(v.temp, 1) as temp, v.heartRate, v.o2, v.steps, v.insertTime from user u, vitalsign v where u.id = v.userid";
		List<VitalsignVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<VitalsignVO>(VitalsignVO.class));
		return list;
	}

	public List<GpsVO> gps() {
		String sql = "select u.id, u.name, g.lat, g.lon, g.recordTime from user u, gps g where u.id = g.userId;";
		List<GpsVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<GpsVO>(GpsVO.class));
		return list;
	}
}
