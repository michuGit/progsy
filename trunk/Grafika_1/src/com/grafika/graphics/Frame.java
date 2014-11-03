package com.grafika.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.grafika.helpers.Helper;
import com.grafika.starter.Main;

public class Frame extends JFrame {
	static Logger log = Logger.getLogger(Main.class.getName());

	private final int width = 1024;
	private final int height = 768;

	private ButtonPanel buttonPanel;
	private ImagePanel imagePanel;
	private ToolsPanel toolsPanel;

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
		this.imagePanel = new ImagePanel(this);
		this.buttonPanel = new ButtonPanel(this);
		this.toolsPanel = new ToolsPanel(this);

		add(this.buttonPanel, BorderLayout.WEST);
		add(this.imagePanel, BorderLayout.CENTER);
		add(this.toolsPanel, BorderLayout.EAST);

		this.imagePanel.updateUI();

	}

	public void setImagePanel() {
		this.imagePanel.changeImage(Helper.promptForFile(this));
		this.imagePanel.setBorder(BorderFactory.createLineBorder(Color.red));
		this.imagePanel.updateUI();
	}
}
