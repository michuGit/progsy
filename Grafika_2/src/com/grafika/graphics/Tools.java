package com.grafika.graphics;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.grafika.helpers.Helper;
import com.grafika.matrix.Transformation;

public class Tools extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(Tools.class.getName());

	JButton openButton = new Button("Otwórz obraz");
	JButton transformationButton = new Button("Transformacja");
	JButton closeButton = new Button("Zamknij");
	JTextArea textArea = new JTextArea();
	Component parent;

	public Tools(Component parent) {
		super();
		this.parent = parent;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(openButton);
		add(transformationButton);
		add(scrollPane);
		add(closeButton);
		textArea.setFont(getFont());
		openButton.addActionListener(this);
		closeButton.addActionListener(this);
		transformationButton.addActionListener(this);
		textArea.setText(Helper.readFile("file.dat"));
		log.info(textArea.getText().length());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openButton) {
			log.info("Otwieranie pliku");
			String path = Helper.promptForFile(this);
			((Frame) parent).image.changeImage(path);
		} else if (e.getSource() == transformationButton) {
			Helper.convertToMatrix(textArea.getText());
			PrintWriter out = null;
			try {
				out = new PrintWriter("file.dat");
				out.println(textArea.getText());
				out.close();
				log.info("Zapisano plik " + textArea.getText());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			out.println(textArea.getText());
		} else if (e.getSource() == closeButton) {
			log.info("Zamykanie programu");
			System.exit(0);
		}
	}

}
