package com.practise.java;

import net.bytebuddy.implementation.bind.annotation.Super;

class Secondclass extends Inheritancclass {
	public void multiply(int x, int y) {
		
		c = x * y;
		
		System.out.println(c);
	}

}

public class Inheritancclass {
	int a;
	int b;
	int c;
	int num=100;

	public void sumOfNumbers(int x, int y) {
		a = x + y;
		b = x - y;
		System.out.println(a);
		System.out.println(b);
	}

	public static void main(String[] args) {
		Secondclass c2 = new Secondclass();
		c2.multiply(6, 9);
		c2.sumOfNumbers(4, 6);
		

	}

}
