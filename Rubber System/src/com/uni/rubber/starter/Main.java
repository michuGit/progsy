package com.uni.rubber.starter;

import org.apache.log4j.Logger;

import com.umi.rubber.properties.PropertiesLoader;
import com.uni.rubber.window.MyMainWindow;

public class Main {
	static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		log.info("Ruber System started...");
		PropertiesLoader mPropertiesLoader= new PropertiesLoader();
		MyMainWindow mainWindow = new MyMainWindow();

	}

}
