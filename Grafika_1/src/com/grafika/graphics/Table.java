package com.grafika.graphics;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import com.grafika.starter.Main;

public class Table extends JTable implements KeyListener{
	static Logger log = Logger.getLogger(Main.class.getName());

	private static final long serialVersionUID = 1L;

	Object[] columnNames = { "Nazwisko", "Figura", "Widocznoœæ" };

	Object[][] data = {};

	public Table() {
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		this.setModel(model);
		setPreferredScrollableViewportSize(getPreferredSize());
		addKeyListener(this);
	}

	public void addData(Object[][] data) {
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		this.setModel(model);
		getModel().addTableModelListener(new TableModelListener() {

			public void tableChanged(TableModelEvent e) {
				// for(int i=0;this.)
				int i = getSelectedRow();
				int j = getSelectedColumn();
				ImagePanel.data.get().get(i).visible = (boolean) getValueAt(i,
						j);

			}
		});
		setPreferredScrollableViewportSize(getPreferredSize());
		repaint();
		updateUI();
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
		default:
			return Boolean.class;
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if (key == KeyEvent.VK_DELETE) {
			log.info("Delete " + getSelectedRow()+" row");
			ImagePanel.data.get().remove(getSelectedRow());
			ImagePanel.saveData();
			ImagePanel.loadData();
		}


	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
