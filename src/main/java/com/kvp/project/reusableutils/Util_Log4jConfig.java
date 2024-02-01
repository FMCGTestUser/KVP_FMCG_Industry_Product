package com.kvp.project.reusableutils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Util_Log4jConfig {

	File myfile=new File("Project_Configurations/log4j.properties");
	
	public Logger testLogs() throws IOException {
		FileInputStream file=new FileInputStream(myfile);
		Properties prop = new Properties();
		prop.load(file);
		Logger log = Logger.getLogger(Util_Log4jConfig.class);
		BasicConfigurator.configure();
		PropertyConfigurator.configure(file);
		return log;	
	}
}
