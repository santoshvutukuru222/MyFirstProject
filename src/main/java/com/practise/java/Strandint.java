package com.practise.java;

public class Strandint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dataarray= {"hello","are" ,"you","its","me"};
		int [] intgerarray= {1,2,3,4,5};
		for (int i=dataarray.length-1;i>=0;i--) {
			System.out.println(dataarray[i]+" "+intgerarray[i]);
		}
	for(String stringData : dataarray) {
	System.out.println(stringData);
	}
	for (int intData: intgerarray) {
		System.out.println(intData);
	}
	char[] characterarray= {'h','e','l','l','o'};
	for(char charVariable: characterarray)
		System.out.println(charVariable);
	String s= "Learning java";

	char[] convertedarray=s.toCharArray();
System.out.println(convertedarray);

String temp="";

for (char c : convertedarray) {
	System.out.println(c);
temp=temp+c;	
}
System.out.println(temp+" temp");
	}





	}
