package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.AnnouncementVO;
import io.swagger.annotations.Api;


@RestController
@Api(description = "공지사항 페이지")
public class AnnouncementController {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@GetMapping("/announcement")
    public List<AnnouncementVO> getMember(String id) {
        String sql = "SELECT * from announcement";
        RowMapper<AnnouncementVO> rowMapper = new BeanPropertyRowMapper<>(AnnouncementVO.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
	
	
	@PostMapping("/announcement")
	public void addAnnouncement(
	    @RequestParam("title") String title,
	    @RequestParam("contents") String contents,
	    @RequestParam("writer") String writer
	) {
	    String sql = "INSERT INTO announcement (title, contents, curdate, writer) VALUES (?, ?, now(), ?)";
	    jdbcTemplate.update(sql, title, contents, writer);
	}

	
	@PutMapping("/announcement/{id}")
	public void updateAnnouncement(@PathVariable int id, @RequestParam String title, @RequestParam String contents) {
	    AnnouncementVO announcement = new AnnouncementVO();
	    announcement.setTitle(title);
	    announcement.setContents(contents);
	    
	    String sql = "UPDATE announcement SET title = ?, contents = ? WHERE id = ?";
	    jdbcTemplate.update(sql, announcement.getTitle(), announcement.getContents(), id);
	}


	@DeleteMapping("/announcement/{id}")
	public void deleteAnnouncement(@PathVariable("id") int id) {
	    String sql = "DELETE FROM announcement WHERE id = ?";
	    jdbcTemplate.update(sql, id);
	}
}


