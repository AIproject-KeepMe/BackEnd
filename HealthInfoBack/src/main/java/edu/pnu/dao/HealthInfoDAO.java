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
		// id, 이름, 나이, 연락처, 직위, 입사일자, 심박, 체온, 산소포화도, 상태, 걸음수, 위도, 경도, 기록일자
		String sql = String.format("select w.workerId as id, w.name, ROUND((TO_DAYS(NOW()) - (TO_DAYS(w.birth))) / 365) AS age, w.contact, w.position, w.role, w.employedDate, h.heartRate, round(h.temperature, 1) as temperature, h.o2, h.status, h.steps, h.lat, h.lon, h.recordTime, h.result FROM worker w, HealthLog h where (w.workerId = %s) and (w.workerId = h.workerId) order by recordTime desc", id);
		List<HealthInfoVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<HealthInfoVO>((HealthInfoVO.class)));
		return list.get(0);
	}
	
	// 오래된 순으로 나오도록 서브쿼리로 싸서 다시 정렬
	public List<HealthInfoVO> getFirstTenHealthInfo(String id) {
		String sql = String.format("SELECT w.workerId AS id, w.name, \r\n"
				+ "    ROUND((TO_DAYS(NOW()) - (TO_DAYS(w.birth))) / 365) AS age, \r\n"
				+ "    w.contact, w.position, w.role, w.employedDate, \r\n"
				+ "    h.heartRate, ROUND(h.temperature, 1) AS temperature, h.o2, h.status, h.steps, \r\n"
				+ "    h.lat, h.lon, h.recordTime, h.result \r\n"
				+ "FROM worker w \r\n"
				+ "JOIN HealthLog h \r\n"
				+ "ON w.workerId = h.workerId \r\n"
				+ "WHERE w.workerId = %s \r\n"
				+ "AND NOT EXISTS (\r\n"
				+ "    SELECT * \r\n"
				+ "    FROM HealthLog h2 \r\n"
				+ "    WHERE h2.workerId = h.workerId \r\n"
				+ "    AND h2.recordTime > h.recordTime \r\n"
				+ "    AND TIMESTAMPDIFF(MINUTE, h.recordTime, h2.recordTime) < 1\r\n"
				+ ")\r\n"
				+ "ORDER BY h.recordTime DESC;", id);
		List<HealthInfoVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<HealthInfoVO>((HealthInfoVO.class)));
		return list;
	}

	public List<HealthInfoVO> getHealthInfoAll() {
		// 서브쿼리의 별칭을 latestLog로
		String sql = "SELECT w.workerId AS id, w.name, \r\n"
				+ "  ROUND((TO_DAYS(NOW()) - (TO_DAYS(w.birth))) / 365) AS age, \r\n"
				+ "  w.contact, w.position, w.role, w.employedDate, \r\n"
				+ "  h.heartRate,  h.o2, round(h.temperature, 1) as temperature, h.status, h.steps, h.lat, h.lon, h.recordTime, h.result \r\n"
				+ "FROM worker w \r\n"
				+ "JOIN HealthLog h ON w.workerId = h.workerId \r\n"
				+ "JOIN (\r\n"
				+ "  SELECT workerId, MAX(recordTime) AS maxRecordTime \r\n"
				+ "  FROM HealthLog \r\n"
				+ "  GROUP BY workerId\r\n"
				+ ") latestLog ON h.workerId = latestLog.workerId AND h.recordTime = latestLog.maxRecordTime \r\n"
				+ "ORDER BY h.recordTime DESC;";
		List<HealthInfoVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<HealthInfoVO>((HealthInfoVO.class)));
		return list;
	}
}