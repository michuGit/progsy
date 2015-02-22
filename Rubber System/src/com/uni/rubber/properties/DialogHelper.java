package com.uni.rubber.properties;

import javax.swing.JOptionPane;

public class DialogHelper {
	public static int confirmDialog() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Zamknąć aplikację?", "Zamykanie aplikacji...", JOptionPane.YES_NO_OPTION);
		return dialogResult;
	}
}
