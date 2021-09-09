package home.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import home.KeyChain.createFile;
import home.password.Cipher;
import home.password.Password;



public class getPasswordGUI extends createPasGUI implements ActionListener {
	
	
	public getPasswordGUI() {
		super();
	}
	
	
	
	public void setup() {
		setHeadingLabel(getHeadingLabel(), "Get password");
		setupStatus();
	}
	
	public void compile() {
		try {
			if(checkDuplicate()) {
				Password p = createFile.findPassword(getFieldInfo(getWebsiteField()));
				displayMessage(p.getPassword());
			}
			else {
				displayMessage("Wrong website");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
}
	


