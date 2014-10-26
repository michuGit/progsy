package com.uni.rubber.window;

import javax.swing.JInternalFrame;

public class MyInternalFrame extends JInternalFrame {

	/**
	 * Create the frame.
	 */
	public MyInternalFrame() {
		super("", true, true, true, true);
		setBounds(100, 100, 450, 300);
		setVisible(true);
	}

	public MyInternalFrame(String titleName) {
		super(titleName, true, true, true, true);
		setBounds(100, 100, 450, 300);
		setVisible(true);
	}

}
