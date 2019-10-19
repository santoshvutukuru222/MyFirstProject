package com.practise.java;

public class Exercising {

	public static void main(String[] args) {
		int[] myarray = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < myarray.length; i++) {
			if (i == 4)
				break;
			else
				System.out.println("i value is not equal to 4" + i);
		}

	}
}
