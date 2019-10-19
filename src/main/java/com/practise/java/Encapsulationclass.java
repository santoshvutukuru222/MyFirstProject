package com.practise.java;

public class Encapsulationclass {
	// private String name;
	private int age = 18;
	private String name;
	private int rollNo;
	

	@Override
	public String toString() {
		return "Encapsulationclass [age=" + age + ", name=" + name + ", rollNo=" + rollNo + "]";
	}


	public int getage() {
		return age;

	}

	
	public int getrollno() {
		return rollNo;
	}

	public void setrollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getname() {
		return name;
	}

}
