package com.practise.java;

public class loops {
	static int i = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int x = 20; x > 20; x = x - 1) {
			System.out.println(x);

		}

		int[] arr = new int[5];

		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		while (i > 0) {
			// while i>0;
			System.out.println(i);
			i++;
		}

		int numbers[] = { 10, 20, 30, 40 };
		for (int x : numbers) {
			System.out.println(x);
			if (x == 40)
				;
			break;
		}

		String stringarray[] = new String[5];

		String[] dataarray = { "hello", "where", "are" };
		
		for(String variable:dataarray) {
			System.out.println(dataarray);
		}

	}

}
