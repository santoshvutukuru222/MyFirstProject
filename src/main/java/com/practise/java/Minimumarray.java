package com.practise.java;

public class Minimumarray {

	public static void main(String[] args) {
		int[] array1 = { 6, 8, 999, 76, 5115,2, 9 };
		int min = array1[0];
		for (int i = 1; i < array1.length; i++) {
			if (array1[i] < min) {
				min = array1[i];

			}

		}
		System.out.println(min);

	}

}
