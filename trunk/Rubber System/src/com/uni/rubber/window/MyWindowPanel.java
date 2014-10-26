package com.uni.rubber.window;

import javax.swing.JPanel;

public class MyWindowPanel extends JPanel {
MyInternalFrame nn ;
	/**
	 * Create the panel.
	 */
	public MyWindowPanel() {
		super();
		nn=new MyInternalFrame();
		add(nn);
	}

}
