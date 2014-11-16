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

import com.grafika.helpers.Helper;
import com.grafika.properties.Properties;
import com.grafika.starter.Main;

public class ButtonPanel extends JPanel implements ActionListener {
	static Logger log = Logger.getLogger(Main.class.getName());

	Component parent;

	JButton buttonOpenImage;
	JButton buttonOpenData;
	JButton buttonCloseImage;

	public ButtonPanel(Component parent) {
		super();
		this.parent = parent;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Properties.BackgroundColor);

		this.buttonOpenData = new Button("Otwórz plik");
		this.buttonOpenImage = new Button("Otwórz obraz");
		this.buttonCloseImage = new Button("Zamknij");

		add(buttonOpenImage);
		add(buttonOpenData);
		add(buttonCloseImage);

		this.buttonOpenData.addActionListener(this);
		this.buttonOpenImage.addActionListener(this);
		this.buttonCloseImage.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonOpenImage) {
			log.info("Otworz obraz");
			((Frame) this.parent).setImagePanel();
		}
		if (e.getSource() == buttonOpenData) {
			log.info("Otworz dane");

			Properties.filename = Helper.promptForFile(this);
			ImagePanel.loadData();
		}
		if (e.getSource() == buttonCloseImage) {
			log.info("Zamknij program");
			System.exit(0);
		}
	}
}
