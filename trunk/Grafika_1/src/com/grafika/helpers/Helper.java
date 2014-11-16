package com.grafika.helpers;

import java.awt.Component;

import javax.swing.JFileChooser;

public class Helper {
	public static String promptForFile(Component parent) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile().getAbsolutePath();
		} else {
			return null;
		}
	}
	
	public static String promptForSaveFile(Component parent) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile().getAbsolutePath();
		} else {
			return null;
		}
	}
}
