package com.umi.rubber.properties;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.UIManager;

import org.apache.log4j.Logger;

public class PropertiesLoader {
	static Logger log = Logger.getLogger(PropertiesLoader.class.getName());

	public PropertiesLoader(Component component) throws IOException, URISyntaxException {
		for (int i = 0; i < Properties.UIManagerProperties.length; i++) {
			UIManager.put(Properties.UIManagerProperties[i][0], Properties.UIManagerProperties[i][1]);
		}
	}
}
