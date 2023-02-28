package edu.pnu.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VitalsignVO {

    private int id;
    private String name;
    private int age;
    private float temp;
    private int heartRate;
    private int o2;
    private int steps;
    private LocalDateTime insertTime;

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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public float getTemp() {
        return temp;
    }
    public void setTemp(float temp) {
        this.temp = temp;
    }
    public int getHeartRate() {
        return heartRate;
    }
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }
    public int getO2() {
        return o2;
    }
    public void setO2(int o2) {
        this.o2 = o2;
    }
    public int getSteps() {
        return steps;
    }
    public void setSteps(int steps) {
        this.steps = steps;
    }
    public String getInsertTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return insertTime.format(formatter);
    }

    public void setInsertTime(String insertTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(insertTime, formatter);
        this.insertTime = dateTime;
    }
}
