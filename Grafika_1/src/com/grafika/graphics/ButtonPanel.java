package com.grafika.graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.grafika.properties.Properties;
import com.grafika.starter.Main;

public class ButtonPanel extends JPanel implements ActionListener {
	static Logger log = Logger.getLogger(Main.class.getName());

	Component parent;

	JButton buttonOpenImage;
	JButton buttonCloseImage;

	public ButtonPanel(Component parent) {
		super();
		this.parent = parent;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Properties.BackgroundColor);
		
		
		this.buttonOpenImage = new Button("Otwórz");
		this.buttonCloseImage = new Button("Zamknij");

		add(buttonOpenImage);
		add(buttonCloseImage);

		this.buttonOpenImage.addActionListener(this);
		this.buttonCloseImage.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonOpenImage) {
			log.info("Otworz obraz");
			((Frame) this.parent).setImagePanel();
		}
		if (e.getSource() == buttonCloseImage) {
			log.info("Zamknij program");
			System.exit(0);
		}
	}
}
