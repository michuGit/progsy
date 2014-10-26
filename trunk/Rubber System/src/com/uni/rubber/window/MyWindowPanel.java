package com.uni.rubber.window;

import javax.swing.JPanel;

public class MyWindowPanel extends JPanel {
MyInternalFrame internalFrame ;
	/**
	 * Create the panel.
	 */
	public MyWindowPanel() {
		super();
		internalFrame=new MyInternalFrame();
		add(internalFrame);
	}

}
