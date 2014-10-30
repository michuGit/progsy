package com.grafika.graphics;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private final int width = 1024;
	private final int height = 768;

	public Frame() {
		super("Grafika_1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - width)),
				(int) (0.5 * (screenSize.height - height)), width, height);
		setVisible(true);

		System.out.println("Screene dimension: "+ screenSize.width + "x" + screenSize.height);
	}
}
