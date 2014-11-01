package com.grafika.starter;

import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.grafika.graphics.Frame;

public class Main {
	static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		log.info("Grakika_1");
		Frame frame = new Frame();
	}

}
