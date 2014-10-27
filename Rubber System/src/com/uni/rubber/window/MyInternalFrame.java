package com.uni.rubber.window;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;

import com.uni.rubber.production.Product;
import com.uni.rubber.structure.ScrollPane;
import com.uni.rubber.structure.Table;

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

		String columnNames[] = { "Column 1", "Column 2", "Column 3" };

		// Create some data
		String dataValues[][] = { { "12", "234", "67" },
				{ "-123", "43", "853" },  { "93", "89.2", "109" },
				{ "279", "9033", "3092" } };

		Table tab = new Table(dataValues, columnNames);
		ScrollPane scrollPane = new ScrollPane(tab);
		add(scrollPane, BorderLayout.CENTER);
	}

}
