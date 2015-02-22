package com.uni.rubber.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.uni.rubber.helper.BooleanHelper;
import com.uni.rubber.helper.ObjectHelper;
import com.uni.rubber.helper.XMLLanguageLoaderHelper;
import com.uni.rubber.properties.DialogHelper;
import com.uni.rubber.properties.Properties;

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

		Map<String, String> labels = XMLLanguageLoaderHelper.XMLLanguageLoaderHelperReader(Properties.MENU_LABELS);
		JMenu mieszanki = new JMenu(labels.get("mixes"));
		JMenu granulaty = new JMenu(labels.get("granules"));
		JMenu raporty = new JMenu(labels.get("reports"));
		JMenu magazyn = new JMenu(labels.get("magazine"));
		JMenu uzytkowicy = new JMenu(labels.get("users"));
		JMenu ustawienia = new JMenu(labels.get("settings"));

		menuBar.add(mieszanki);
		menuBar.add(granulaty);
		menuBar.add(raporty);
		menuBar.add(magazyn);
		menuBar.add(uzytkowicy);
		menuBar.add(ustawienia);

		JMenuItem nowaMieszanka = new JMenuItem("Dodaj nową mieszankę");
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
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		while (ObjectHelper.isNull(loginWindow) || BooleanHelper.isFalse(loginWindow.getPrivilage())) {
			loginWindow = new LoginWindow();
		}
	}
}
