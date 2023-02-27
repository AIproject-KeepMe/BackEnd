package edu.pnu.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class AnnouncementVO {

	public int id;
	public String title;
	public String contents;
	public Date curdate;
	public String writer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCurdate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(curdate); 
	}
	public void setCurdate(Date curdate) {
		this.curdate = curdate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
}
