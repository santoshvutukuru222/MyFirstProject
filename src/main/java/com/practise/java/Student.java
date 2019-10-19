package com.practise.java;

public class Student {

	String name;
	static String colleage="JNTU";
	String studentName;
	String studentEmail;
	int sno;
	int marks1;
	int marks2;
	
	int[] numbersex= {1,3,4,54};
	int[] numbersunkown= new int[5];
	
	private String privateVariable;

	public String getPrivateVariable() {
		return privateVariable;
	}
	public void setPrivateVariable(String privateVariable) {
		this.privateVariable = privateVariable;
	}

	static {
		String staticblockExample = "I am in static block";
		System.out.println(staticblockExample);
		System.out.println(colleage);

	}

	public Student() {
		String street=" I am street in constructor";
		System.out.println(street+"Street");
		System.out.println(marks1);
	}
	public Student(int marks1,int marks2) {
		this.marks1=marks1;
		this.marks2=marks2;
	}

	public void Sumofmarks() {
		String location = "Hyderabad";

		colleage = "SCSVMV";
		int sum = marks1 + marks2;
		System.out.println(sum);
		System.out.println("colleage");
		System.out.println(marks1);
	}

	public static void main(String[] args) {
System.out.println("i am main method");
		/*Student s = new Student();
		s.marks1 = 45;
		s.marks2 = 54;
		s.Sumofmarks();

		Student s1 = new Student();
		s1.marks1 = 45;
		s1.marks2 = 54;
		s1.Sumofmarks();*/
		
		Student s2= new Student(10, 20);
		s2.Sumofmarks();
		System.out.println(" using parameters");
		
		System.out.println("\\");
		// s1.

		//System.out.println(Student.colleage + "Student");

		// Student.

	}

}
