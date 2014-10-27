package com.uni.rubber.window;

import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.UIManager;

public class MyWindowPanel extends JDesktopPane {
	public MyWindowPanel() {
		super();
		setBackground(Configuration.BackgroundColor);
	}

}
