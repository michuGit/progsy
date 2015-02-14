package com.uni.rubber.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.uni.rubber.properties.DialogHelper;

public class MyMainWindow extends JFrame {
	static Logger log = Logger.getLogger(MyMainWindow.class.getName());
	private MyWindowPanel contentPane;
	private LoginWindow loginWindow;

	public MyMainWindow() {
		super(WindowLabels.Name);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
				MyInternalFrame internalFrame = new MyInternalFrame("Dodawanie mieszanki");
				contentPane.add(internalFrame);
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (DialogHelper.confirmDialog() == 0) {
					log.info("Zamykanie aplikacji.");
					System.exit(0);
				} else {
					log.info("Anulowanie zamykania aplikacji.");
				}
			}
		});
		setVisible(true);
		setSize(1024, 768);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
	
	
	loginWindow=new LoginWindow();
	
	}
}
