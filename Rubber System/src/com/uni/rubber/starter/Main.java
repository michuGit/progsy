package com.uni.rubber.starter;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.uni.rubber.database.HibernateUtils;
import com.uni.rubber.helper.XMLLanguageLoaderHelper;
import com.uni.rubber.properties.PropertiesLoader;
import com.uni.rubber.window.MyMainWindow;
//test
public class Main {
	static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws IOException, URISyntaxException {
		log.info("Ruber System started...");
		HibernateUtils.connect();
		log.info("Tables have been loaded");
		HibernateUtils.select("FROM User");
		HibernateUtils.select("FROM BomHeader");

		MyMainWindow mainWindow = new MyMainWindow();
		log.info("Loading properties...");
		PropertiesLoader mPropertiesLoader = new PropertiesLoader(mainWindow);
	}
}
 