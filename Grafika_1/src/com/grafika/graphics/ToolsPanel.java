package com.grafika.graphics;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.log4j.Logger;

import com.grafika.properties.Properties;
import com.grafika.starter.Main;

public class ToolsPanel extends JPanel {
	static Logger log = Logger.getLogger(Main.class.getName());

	Component parent;

	GroupRadioButtonPanel radioButtonPanel;
	JScrollPane mJScrollPane;
	NamePanel namePanel;

	public static Table table = null;

	public ToolsPanel(Component parent) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Properties.BackgroundColor);
		this.parent = parent;

		this.radioButtonPanel = new GroupRadioButtonPanel();
		add(this.radioButtonPanel);

		this.namePanel = new NamePanel(this);
		add(this.namePanel);

		this.mJScrollPane = new JScrollPane(table);
		add(this.mJScrollPane);
	}

}
