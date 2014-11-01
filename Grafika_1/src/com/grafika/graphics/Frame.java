package com.grafika.graphics;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.grafika.starter.Main;

public class Frame extends JFrame {
	static Logger log = Logger.getLogger(Main.class.getName());

	private final int width = 1024;
	private final int height = 768;

	public Frame() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		super("Grafika_1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - width)),
				(int) (0.5 * (screenSize.height - height)), width, height);
		setVisible(true);

		log.info("Screene dimension: " + screenSize.width + "x"
				+ screenSize.height);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// new java.awt.FileDialog((java.awt.Frame) null).setVisible(true);
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
	}
}
