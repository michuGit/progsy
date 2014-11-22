package com.grafika.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame extends JFrame {
	static Logger log = Logger.getLogger(Frame.class.getName());

	private final int width = 1024;
	private final int height = 768;

	public Frame() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		super("Grafika_2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - width)),
				(int) (0.5 * (screenSize.height - height)), width, height);
		setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setLayout(new BorderLayout());
		setVisible(true);		
		update(getGraphics());
		repaint();

	}

}
