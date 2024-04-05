package com.kvp.testcases.Android;

public class Testtempresult {
	    
	public static void main(String[] args){  
	    	String givenText = "I love india";
	        String[] words = givenText.split(" ");
	        String tempArray="";
	       
	        for(int i=words.length-1;i>=0;i--) {
	        	tempArray = tempArray+" "+words[i];
	        
	        }
	        System.out.println(tempArray.trim());
	    }
	    
	
//	public static void main(String[] args) {
//	    String givenText = "I love india";
//	    String[] words = givenText.split(" ");
//	    
//	    for (int i = words.length - 1; i >= 0; i--) {
//	        System.out.print(words[i].toString() + " ");
//	    }
//	}
}
