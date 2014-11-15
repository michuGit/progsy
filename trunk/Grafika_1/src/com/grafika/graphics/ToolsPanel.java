package com.grafika.graphics;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.grafika.properties.Properties;

public class ToolsPanel extends JPanel {
	Component parent;

	GroupRadioButtonPanel radioButtonPanel;
	JScrollPane mJScrollPane;
	public static Table table=null;
	public ToolsPanel(Component parent) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Properties.BackgroundColor);
		this.parent = parent;

		this.radioButtonPanel = new GroupRadioButtonPanel();
		add(this.radioButtonPanel);
//		table=new Table();
		this.mJScrollPane=new JScrollPane(table);
		add(this.mJScrollPane);
	}
}
