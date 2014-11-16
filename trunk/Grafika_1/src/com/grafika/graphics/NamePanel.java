package com.grafika.graphics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.log4j.Logger;

import com.grafika.properties.Properties;
import com.grafika.starter.Main;

public class NamePanel extends JPanel {
	static Logger log = Logger.getLogger(Main.class.getName());

	JLabel label = new JLabel("U¿ytkownik");
	JTextField text = new JTextField("", 25);

	public NamePanel(Component parent) {
		setLayout(new GridLayout(1, 2));
		add(label);
		add(text);
		setPreferredSize(new Dimension(100, 25));
		setMinimumSize(new Dimension(350, 25));
		setMaximumSize(new Dimension(350, 25));

		text.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				Properties.userName = text.getText();
				log.info("###### text changed...");
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				Properties.userName = text.getText();
				log.info("###### text changed...");
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				Properties.userName = text.getText();
				log.info("###### text changed...");
			}
		});
	}

}
