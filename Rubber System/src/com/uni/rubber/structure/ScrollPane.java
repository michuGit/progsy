package com.uni.rubber.structure;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ScrollPane extends JScrollPane {
	public ScrollPane() {
		super();
	}
	
	public ScrollPane(JTable table){
		super(table);
	}
}
