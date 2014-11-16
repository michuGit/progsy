package com.grafika.helpers;

import java.awt.Component;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.log4j.Logger;

import com.grafika.matrix.Transformation;

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
		List<Matrix> list = new ArrayList<Matrix>();
		String[] data = text.split("\\s");
		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < data.length; i++) {
			if (!data[i].isEmpty()) {
				temp.add(data[i]);
				log.info(data[i]);
			}
		}
		data = temp.toArray(data);
		for (int i = 0; i < data.length / 9; i++) {
			double[][] mat = new double[3][3];
			for (int j = 0; j < 9; j++) {
				if (data[i * 9 + j].contains("s")) {
					log.info("sinus");
					mat[j / 3][j % 3] = Math.sin(Math.toRadians(Double
							.parseDouble(data[i * 9 + j].replace("s", ""))));
				} else if (data[i * 9 + j].contains("c")) {
					log.info("cosinus");
					mat[j / 3][j % 3] = Math.cos(Math.toRadians(Double
							.parseDouble(data[i * 9 + j].replace("c", ""))));
				} else {
					mat[j / 3][j % 3] = Double.parseDouble(data[i * 9 + j]);
				}
			}
			list.add(new Matrix(mat));
		}
		Transformation.transformacje = list;
	}
}
