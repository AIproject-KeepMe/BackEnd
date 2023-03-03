package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import edu.pnu.domain.HealthInfoVO;

@Repository
public class HealthInfoDAO {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public HealthInfoVO getHealthInfo(String id) {
		
		String sql = String.format("select workerId as id, w.name, ROUND((TO_DAYS(NOW()) - (TO_DAYS(w.birth))) / 365) AS age, w.contact, w.position, w.role, w.employedDate, h.heartRate, round(h.temperature, 1) as temperature, h.o2, h.status, h.steps, h.lat, h.lon, h.recordTime FROM worker w, HealthLog h where (workerId = %s) and (w.workerId = h.userId) order by recordTime desc", id);
		List<HealthInfoVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<HealthInfoVO>((HealthInfoVO.class)));
		return list.get(0);
	}

	public List<HealthInfoVO> getHealthInfoAll() {
		// 서브쿼리도 별칭을 붙일 수 있다. 여기서는 latestLog로 붙임
		String sql = "SELECT w.workerId AS id, w.name, \r\n"
				+ "  ROUND((TO_DAYS(NOW()) - (TO_DAYS(w.birth))) / 365) AS age, \r\n"
				+ "  w.contact, w.position, w.role, w.employedDate, \r\n"
				+ "  h.heartRate, round(h.temperature, 1) as temperature, h.o2, h.status, h.steps, h.lat, h.lon, h.recordTime \r\n"
				+ "FROM worker w \r\n"
				+ "JOIN HealthLog h ON w.workerId = h.userId \r\n"
				+ "JOIN (\r\n"
				+ "  SELECT userId, MAX(recordTime) AS maxRecordTime \r\n"
				+ "  FROM HealthLog \r\n"
				+ "  GROUP BY userId\r\n"
				+ ") latestLog ON h.userId = latestLog.userId AND h.recordTime = latestLog.maxRecordTime \r\n"
				+ "ORDER BY h.recordTime DESC;";
		List<HealthInfoVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<HealthInfoVO>((HealthInfoVO.class)));
		return list;
	}
}