package edu.pnu.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HealthInfoVO {

	private String id;
	private String name;
	private int age;
	private String contact;
	private String position;
	private String role;
	private Date employedDate;
	private int heartRate;
	private double temperature;
	private double o2;
	private String status;
	private int steps;
	private double lat;
	private double lon;
	private LocalDateTime recordTime;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmployedDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(employedDate); 
	}
	public void setEmployedDate(Date employedDate) {
		this.employedDate = employedDate;
	}
	public int getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
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