package com.grafika.graphics;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GroupRadioButtonPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JRadioButton elipsa;
	public static JRadioButton prostokat;
	public static JRadioButton wielokat;
	public JButton kolor;
	public static Color color;

	public GroupRadioButtonPanel() {
		super();
		// setBackground(Properties.BackgroundColor);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		elipsa = new JRadioButton("Elipsa");
		prostokat = new JRadioButton("Prostokąt");
		wielokat = new JRadioButton("Wielokąt");
		this.kolor = new Button("Kolor", false);

		ButtonGroup group = new ButtonGroup();
		group.add(elipsa);
		group.add(prostokat);
		group.add(wielokat);

		add(elipsa);
		add(prostokat);
		add(wielokat);
		add(kolor);

		this.setVisible(true);
	}
}
