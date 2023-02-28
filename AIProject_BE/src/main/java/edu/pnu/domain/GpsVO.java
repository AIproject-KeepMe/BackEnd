package edu.pnu.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GpsVO {

	private int id;
    private String name;
    private Double lat;
    private Double lon;
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
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLon() {
        return lon;
    }
    public void setLon(Double lon) {
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
