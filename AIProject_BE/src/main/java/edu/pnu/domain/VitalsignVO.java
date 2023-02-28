package edu.pnu.domain;

public class VitalsignVO {

	private int id;
	private String name;
	private int age;
	private float temp;
	private int heartRate;
	private int o2;
	
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
}
