package com.uni.rubber.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyMainWindow extends JFrame {

	private MyWindowPanel contentPane;
	public MyMainWindow() {
		super(WindowLabels.Name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new MyWindowPanel();
		setContentPane(contentPane);
		JMenuBar menuBar = new JMenuBar();
		setLayout(null);
		// Add the menubar to the frame
		setJMenuBar(menuBar);

		// Define and add two drop down menu to the menubar
		JMenu mieszanki = new JMenu("Mieszanki");
		JMenu granulaty = new JMenu("Granulaty");
		JMenu raporty = new JMenu("Raporty");
		JMenu magazyn = new JMenu("Magazyn");
		JMenu uzytkowicy = new JMenu("U¿ytkowicy");
		JMenu ustawienia = new JMenu("Ustawienia");

		menuBar.add(mieszanki);
		menuBar.add(granulaty);
		menuBar.add(raporty);
		menuBar.add(magazyn);
		menuBar.add(uzytkowicy);
		menuBar.add(ustawienia);

		JMenuItem nowaMieszanka = new JMenuItem("Dodaj now¹ mieszankê");
		JMenuItem raportMieszanki = new JMenuItem("Raport mieszanki");
		ButtonGroup bg = new ButtonGroup();
		mieszanki.add(nowaMieszanka);
		mieszanki.add(raportMieszanki);
		nowaMieszanka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Dodawanie nowej mieszanki...");
				MyInternalFrame internalFrame = new MyInternalFrame(
						"Dodawanie mieszanki");
				contentPane.add(internalFrame);
			}
		});
		setVisible(true);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
}
