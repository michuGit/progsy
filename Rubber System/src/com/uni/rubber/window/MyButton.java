package com.uni.rubber.window;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyButton extends JButton {

	public MyButton() {
		super();
	}

	public MyButton(String name) {
		super(name);
		setBorderPainted(true);
//		setFocusPainted(false);

		setContentAreaFilled(false);
		setOpaque(true);

		setBackground(Configuration.ButtonNormalColor);
//		setForeground(Color.WHITE);
		setFont(new Font(Configuration.FontName, Font.BOLD, 12));
		setText(name);
		setHorizontalAlignment(SwingConstants.LEFT);
		addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				if (getModel().isPressed()) {
					setBackground(Configuration.ButtonPressedColor);
				} else if (getModel().isRollover()) {
					setBackground(Configuration.ButtonRolledOverColor);
				} else {
					setBackground(Configuration.ButtonNormalColor);
				}
			}
		});

	}

}
