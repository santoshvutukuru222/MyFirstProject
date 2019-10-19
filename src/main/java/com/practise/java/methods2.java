package com.practise.java;

public class methods2 {
	public void findMaxNumber(int x,int y) {
		int a = x;
		int b = y;
		if (a > b)
			System.out.println(a+" is greater than "+b);
		else
			System.out.println(b+" is greater than "+a);

	}
	public class Methods3 extends methods2{
		//public void 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		methods2 m=new methods2();
		m.findMaxNumber(5, 7);

	}

}
