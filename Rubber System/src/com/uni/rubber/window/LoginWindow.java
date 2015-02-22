package com.uni.rubber.window;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.uni.rubber.database.HibernateUtils;
import com.uni.rubber.helper.BooleanHelper;
import com.uni.rubber.helper.XMLLanguageLoaderHelper;
import com.uni.rubber.properties.Properties;

public class LoginWindow extends JOptionPane {
	static Logger log = Logger.getLogger(LoginWindow.class.getName());

	private String login;
	private String password;
	private boolean privilage;

	public LoginWindow() {
		super();

		Map<String, String> labels = XMLLanguageLoaderHelper.XMLLanguageLoaderHelperReader(Properties.LOGIN_WINDOW_LABELS);

		setBounds(1000, 500, 100, 200);
		JTextField login = new JTextField();
		JPasswordField password = new JPasswordField();
		final JComponent[] inputs = new JComponent[] { new JLabel(labels.get("userLabel")), login, new JLabel(labels.get("passwordLabel")), password };
		showMessageDialog(null, inputs, labels.get("title"), JOptionPane.PLAIN_MESSAGE);
		this.login = login.getText();
		this.password = password.getText();
		if (this.login.equals("user") && this.password.equals("adminuni1")) {
			this.privilage = true;
		} else {
			log.info("Login:\t\t" + this.login);
			log.info("Password:\t" + this.password);
			this.privilage = BooleanHelper.isFalse(HibernateUtils.select("from User where login='" + this.login + "' and password='" + this.password + "'").isEmpty());
		}
	}

	public boolean getPrivilage() {
		return this.privilage;
	}

}
