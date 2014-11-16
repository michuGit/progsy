package com.grafika.helpers;

import java.awt.Component;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.log4j.Logger;

import Jama.Matrix;

public class Helper {
	static Logger log = Logger.getLogger(Helper.class.getName());

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

	public static String readFile(String filename) {
		String content = null;
		File file = new File(filename); // for ex foo.txt
		try {
			FileReader reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public static void convertToMatrix(String text) {
		String[] data = text.split("\\s");
		for (int i = 0; i < data.length; i++) {
			if (!data[i].isEmpty()) {
				
				log.info(data[i]);
			}
		}
		List<Matrix> list = new ArrayList<Matrix>();
		double[][] mat = new double[3][3];
	}
}
