package com.grafika.graphics;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

	private static final long serialVersionUID = 1L;

	Object[] columnNames = { "Nazwisko", "Figura", "Widocznoœæ", "Wyciêcie",
			"Kolor" };

	Object[][] data = {  };

	public Table() {
		// Color c = JColorChooser.showDialog(null, "Choose a Color", null);
		// Object[][] data = { { "John Kowalski", "Owal", true, false, c } };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		this.setModel(model);
		setPreferredScrollableViewportSize(getPreferredSize());
	}

	public void addData(Object[][] data) {
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		this.setModel(model);
		setPreferredScrollableViewportSize(getPreferredSize());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(int column) {
		switch (column) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return Boolean.class;
		case 3:
			return Boolean.class;
		case 4:
			return Color.class;
		default:
			return Boolean.class;
		}
	}
}
