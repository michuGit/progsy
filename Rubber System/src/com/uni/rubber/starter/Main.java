package com.uni.rubber.starter;

import org.apache.log4j.Logger;

import com.uni.rubber.window.MyMainWindow;

public class Main {
	static Logger log = Logger.getLogger(Main.class.getName());
	static MyMainWindow mainWindow;

	public static void main(String[] args) {
		log.info("Ruber System started...");
		mainWindow = new MyMainWindow();

	}

}
