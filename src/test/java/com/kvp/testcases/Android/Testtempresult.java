package com.kvp.testcases.Android;

public class Testtempresult {
	    
	public static void main(String[] args){  
		      String text= "Prasad KVP Business  ra solution sara ";
		      int y=0;
		       int z=0;
		     String temp= text.replace("ra","$").replace(" ","");
		      for(int i=0;i<temp.length();i++){
		          if(temp.charAt(i)=='$'){
		               y=y+1;
		              
		          }else{
		             z=z+1; 
		          }
		          
		          
		      }

		      System.out.println("char count="+z+"dollor count "+y);
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
