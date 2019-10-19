package com.practise.java;

public class Strngclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String [] strarray= new String[5];
       strarray[0]= "hello";
       strarray[1]= "how";
       strarray[2]= "are";
       strarray[3]= "you";
       strarray[4]="itsme";
       for(int i=0;i<strarray.length;i++) {
    	 //  System.out.println(strarray[i]);
       }
       
     //  strarray[3]=strarray[0] +" "+strarray[1]+" " +strarray[2] +" "+strarray[3];
  //     System.out.println(strarray[3]);
       
       String temp="";
       for(String variable:strarray) {
    	   
    	   temp=temp+"\""+variable+"\""+" ";
    	  System.out.println(variable);
       }
       
       System.out.println(temp +" temp");
       
       System.out.println("\"");
       
       
	}

}
