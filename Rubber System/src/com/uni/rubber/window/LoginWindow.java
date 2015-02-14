package com.uni.rubber.window;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginWindow extends JDialog {
	public LoginWindow() {
		super();
		setBounds(1000, 500, 100, 200);
		setVisible(true);
		setModal(false);
//		JOptionPane.showMessageDialog(null,this,"Your title here bro",JOptionPane.PLAIN_MESSAGE);
	}
}
