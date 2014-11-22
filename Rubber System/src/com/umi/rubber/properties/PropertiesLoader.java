package com.umi.rubber.properties;

import javax.swing.UIManager;

public class PropertiesLoader {
	public PropertiesLoader() {
		for (int i = 0; i < Properties.UIManagerProperties.length; i++) {
			UIManager.put(Properties.UIManagerProperties[i][0],
					Properties.UIManagerProperties[i][1]);
		}
	}
}
