package edu.pnu.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class UserVO {

	public String id;
	public String pw;
	public String name;
	public int age;
	public String contact;
	public String position;
	public String role;
	public Date employedDate;
	public String workplace;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
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
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	
	
}
