package com.uni.rubber.window;

import javax.swing.JInternalFrame;

import com.uni.rubber.production.Product;

public class MyInternalFrame extends JInternalFrame {

	/**
	 * Create the frame.
	 */
	Product product;
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
