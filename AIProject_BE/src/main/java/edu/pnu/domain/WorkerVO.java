package edu.pnu.domain;

import java.time.LocalDateTime;

public class WorkerVO {
	private String user;
	private LocalDateTime recorded_time;
	private String status;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public LocalDateTime getRecorded_time() {
		return recorded_time;
	}
	public void setRecorded_time(LocalDateTime recorded_time) {
		this.recorded_time = recorded_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
