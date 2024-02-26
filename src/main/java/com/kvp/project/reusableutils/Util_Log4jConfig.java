package com.kvp.project.reusableutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Util_Log4jConfig {
	
	public Logger testLogs() throws IOException {
		FileInputStream configFile=new FileInputStream("Project_Configurations/log4j.properties");
		Properties prop = new Properties();
		prop.load(configFile);
		configFile.close();
		Logger log = Logger.getLogger("devpinoyLogger");
		BasicConfigurator.configure();
		PropertyConfigurator.configure(prop);
		return log;	
	}
}
