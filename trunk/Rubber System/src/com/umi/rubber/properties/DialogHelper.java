package com.umi.rubber.properties;

import javax.swing.JOptionPane;

public class DialogHelper {
	public static int confirmDialog() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Zamkn¹æ aplikacjê?", "Zamykanie aplikacji...", JOptionPane.YES_NO_OPTION);
		return dialogResult;
	}
}
