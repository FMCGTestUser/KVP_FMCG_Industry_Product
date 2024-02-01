package com.kvp.project.reusableutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util_PropertyConfig {
	
	File myfile=new File("Project_Configurations/Data.properties");	
	Properties prop=new Properties();

	public String propertyFetch(String input) throws IOException {
		FileInputStream file=new FileInputStream(myfile);
		prop.load(file);
			String output= prop.getProperty(input);
			return output;		
		}
}
