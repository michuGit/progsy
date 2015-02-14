package com.uni.rubber.starter;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

import com.uni.rubber.properties.PropertiesLoader;
import com.uni.rubber.window.MyMainWindow;

public class Main {
	static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws IOException, URISyntaxException {
		log.info("Ruber System started...");
		MyMainWindow mainWindow = new MyMainWindow();
		log.info("Loading properties...");
		PropertiesLoader mPropertiesLoader = new PropertiesLoader(mainWindow);
	}
}
