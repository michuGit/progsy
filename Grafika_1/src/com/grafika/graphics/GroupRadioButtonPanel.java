package com.grafika.graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GroupRadioButtonPanel extends JPanel  implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JRadioButton elipsa;
	public static JRadioButton prostokat;
	public static JRadioButton wielokat;
	public static JButton drawButton;
	public static Color color;

	public GroupRadioButtonPanel() {
		super();
		// setBackground(Properties.BackgroundColor);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		elipsa = new JRadioButton("Elipsa");
		prostokat = new JRadioButton("Prostokąt");
		wielokat = new JRadioButton("Wielokąt");
		drawButton = new Button("Skończ rysować", false);
		drawButton.setVisible(false);
		drawButton.addActionListener(this);
		
		ButtonGroup group = new ButtonGroup();
		group.add(elipsa);
		group.add(prostokat);
		group.add(wielokat);

		add(elipsa);
		add(prostokat);
		add(wielokat);
		add(drawButton);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == drawButton) {
			drawButton.setVisible(false);
			ImagePanel.draw=false;
		}	
	}
}
