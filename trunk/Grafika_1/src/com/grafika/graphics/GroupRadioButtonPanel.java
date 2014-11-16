package com.grafika.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.apache.log4j.Logger;

import com.grafika.helpers.Helper;
import com.grafika.properties.Properties;
import com.grafika.starter.Main;

public class GroupRadioButtonPanel extends JPanel implements ActionListener {
	static Logger log = Logger.getLogger(Main.class.getName());

	private static final long serialVersionUID = 1L;
	public static JRadioButton elipsa;
	public static JRadioButton prostokat;
	public static JRadioButton wielokat;
	public static JButton addButton;
	public static JButton addAsButton;
	public static JButton cancelButton;
	public static Color color;

	public GroupRadioButtonPanel() {
		super();
		// setBackground(Properties.BackgroundColor);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		elipsa = new JRadioButton("Elipsa");
		prostokat = new JRadioButton("Prostokąt");
		wielokat = new JRadioButton("Wielokąt");
		addButton = new Button("Zapisz", false);
		addAsButton = new Button("Zapisz jako", false);
		// addButton.setVisible(false);
		addButton.addActionListener(this);
		addAsButton.addActionListener(this);
		cancelButton = new Button("Anuluj", false);
		// cancelButton.setVisible(false);
		cancelButton.addActionListener(this);

		ButtonGroup group = new ButtonGroup();
		group.add(elipsa);
		group.add(prostokat);
		group.add(wielokat);

		add(elipsa);
		add(prostokat);
		add(wielokat);
		add(addButton);
		add(addAsButton);
		add(cancelButton);

		
		setMinimumSize(new Dimension(350, 350));
		setMaximumSize(new Dimension(350, 350));
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			if (ImagePanel.save()) {
				if (Properties.first == false) {
					Properties.filename = Helper.promptForSaveFile(this);
				}
				ImagePanel.saveData();
				ImagePanel.loadData();
				log.info("Dodano...");
			}
		} else if (e.getSource() == addAsButton) {
			ImagePanel.save();
			Properties.filename = Helper.promptForSaveFile(this);
			ImagePanel.saveData();
			ImagePanel.loadData();
			log.info("Dodano...");

		} else if (e.getSource() == cancelButton) {
		}
		ImagePanel.clean();
		ImagePanel.draw = false;
	}
}
