package com.practise.java;

public class StudentMain {
	
	static Student s;

	public static void main(String[] args) {

		s= new Student();
		s.setPrivateVariable("Setting value");
		System.out.println(s.getPrivateVariable());
	}

}
