package com.kvp.testcases.Android;

import java.time.Month;

public class Testtempresult {

	public static void main(String[] args) {
		String str = "Sunday, March 1, 2024";
    	String[] splitText = str.split(",");
		int length = splitText[1].length()-2;  
        Month monthName = Month.valueOf(splitText[1].substring(0,length).replace(" ","").toUpperCase());
        String monthNumeric = String.format("%02d", monthName.getValue());
        int monthNumber = Integer.parseInt(monthNumeric);
    	System.out.println(str);
    	System.out.println(splitText[0]);
    	System.out.println(splitText[1]);
    	System.out.println(splitText[2]);
    	System.out.println(monthName);
     	System.out.println(monthNumeric);
     	System.out.println(monthNumber);

    	
	}

}
