package edu.pnu.domain;

import java.time.LocalDateTime;

public class WorkerVO {

	private int id;
	private String user;
	private int stat;
	private String stat_label;
	private LocalDateTime recorded_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public String getStat_label() {
		return stat_label;
	}
	public void setStat_label(String stat_label) {
		this.stat_label = stat_label;
	}
	public LocalDateTime getRecorded_time() {
		return recorded_time;
	}
	public void setRecorded_time(LocalDateTime recorded_time) {
		this.recorded_time = recorded_time;
	}
	
	@Override
	public String toString() {
		return "WorkerDAO [id=" + id + ", user=" + user + ", stat=" + stat + ", stat_label=" + stat_label
				+ ", recorded_time=" + recorded_time + "]";
	}
	
}
