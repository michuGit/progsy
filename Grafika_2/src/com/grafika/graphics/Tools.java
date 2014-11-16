package com.grafika.graphics;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.grafika.helpers.Helper;
import com.grafika.starter.Main;

public class Tools extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(Tools.class.getName());

	JButton openButton = new Button("Otwórz obraz");
	JButton closeButton = new Button("Zamknij");
	Component parent;

	public Tools(Component parent) {
		super();

		this.parent = parent;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(openButton);
		this.add(closeButton);

		openButton.addActionListener(this);
		closeButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openButton) {
			log.info("Otwieranie pliku");
			String path = Helper.promptForFile(this);
			((Frame) parent).image.changeImage(path);
		} else if (e.getSource() == closeButton) {
			log.info("Zamykanie programu");
			System.exit(0);
		}
	}
}
