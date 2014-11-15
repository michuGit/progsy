package com.grafika.graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.apache.log4j.Logger;

import com.grafika.starter.Main;

public class GroupRadioButtonPanel extends JPanel implements ActionListener {
	static Logger log = Logger.getLogger(Main.class.getName());

	private static final long serialVersionUID = 1L;
	public static JRadioButton elipsa;
	public static JRadioButton prostokat;
	public static JRadioButton wielokat;
	public static JButton addButton;
	public static JButton cancelButton;
	public static Color color;

	public GroupRadioButtonPanel() {
		super();
		// setBackground(Properties.BackgroundColor);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		elipsa = new JRadioButton("Elipsa");
		prostokat = new JRadioButton("Prostokąt");
		wielokat = new JRadioButton("Wielokąt");
		addButton = new Button("Dodaj", false);
		// addButton.setVisible(false);
		addButton.addActionListener(this);
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
		add(cancelButton);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			// addButton.setVisible(false);
			if (ImagePanel.save()) {
				ImagePanel.saveData();
				ImagePanel.loadData();

				log.info("Dodano...");
			}
		} else if (e.getSource() == cancelButton) {
			// addButton.setVisible(false);
			// ImagePanel.clean();
		}
		ImagePanel.clean();
		ImagePanel.draw = false;
	}
}
