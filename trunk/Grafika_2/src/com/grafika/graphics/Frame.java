package com.grafika.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.grafika.starter.Main;

public class Frame extends JFrame {
	static Logger log = Logger.getLogger(Frame.class.getName());

	private final int width = 1024;
	private final int height = 768;

	protected Tools tools;
	protected Image image;
	

	public Frame() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		super("Grafika_1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (screenSize.width - width)),
				(int) (0.5 * (screenSize.height - height)), width, height);
		setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setLayout(new BorderLayout());
		setVisible(true);
		tools = new Tools(this);
		image = new Image();
		JScrollPane scrollPane = new JScrollPane(image); 
		
		add(tools, BorderLayout.WEST);
		add(scrollPane, BorderLayout.CENTER);

		// // this.imagePanel.updateUI();
		Thread th = new Thread(image);
		th.start();
		
		update(getGraphics());
		repaint();

	}

}
