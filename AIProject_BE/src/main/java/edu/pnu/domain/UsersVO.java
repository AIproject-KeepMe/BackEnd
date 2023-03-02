package edu.pnu.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsersVO {

	private int id;
	private String name;
	private int heartReate;
	private double temp;
	private double o2;
	private int steps;
	private double lat;
	private double lon;
	private LocalDateTime recordTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeartReate() {
		return heartReate;
	}
	public void setHeartReate(int heartReate) {
		this.heartReate = heartReate;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getO2() {
		return o2;
	}
	public void setO2(double o2) {
		this.o2 = o2;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public String getRecordTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return recordTime.format(formatter);
	}
	public void setRecordTime(String recordTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.recordTime = LocalDateTime.parse(recordTime, formatter);
	}
	
	
}
