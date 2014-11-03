package com.grafika.graphics;

import java.awt.Dimension;

import javax.swing.JButton;

import org.apache.log4j.Logger;

import com.grafika.properties.Properties;
import com.grafika.starter.Main;

public class Button extends JButton {
	static Logger log = Logger.getLogger(Main.class.getName());

	public final int width = 400;
	public final int height = 25;

	public Button(String label) {
		super(label);
		setBackground(Properties.BackgroundColor);
		setMinimumSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));

		log.info("Przycisk dodany");
	}

	public Button(String label, boolean changeColor) {
		super(label);
		if (changeColor) {
			setBackground(Properties.BackgroundColor);
		}
		setMinimumSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));

		log.info("Przycisk dodany");
	}
}
