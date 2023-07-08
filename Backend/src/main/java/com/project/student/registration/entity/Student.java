package com.project.student.registration.entity;

import java.util.List;

public class Student {
	
	private int rollNo;
	private String name;
	private String age;
	private String address;
	private List<String> mobileNo;
	
	
	public Student() {
		super();
	}


	public Student(int rollNo, String name, String age, String address, List<String> mobileNo) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNo = mobileNo;
	}
	
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(List<String> mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

}
