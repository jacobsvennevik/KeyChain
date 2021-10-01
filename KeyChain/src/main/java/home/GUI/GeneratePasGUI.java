package home.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import home.KeyChain.createFile;
import home.password.Cipher;
import home.password.Password;

public class GeneratePasGUI extends CreatePasGUI implements ActionListener  {
	private static JFormattedTextField lengthField;
	private static JLabel lengthLabel;
	
	public GeneratePasGUI() {
		super();

	}
	

	
	
	public void compile() {
		try {
			if(checkDuplicate()) {
				displayMessage("Password to this website already exists", false);
				return;
			}
			Password p = new Password(getFieldInfo(getWebsiteField()), Integer.parseInt(getFieldInfo(getLengthField())));
			displayMessage(p.getPassword(), true);
			Cipher.encrypt(p, Cipher.randEncryption());
			createFile.writeFile(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JFormattedTextField getLengthField() {
		return lengthField;
	}

	public void setup() {
		setHeadingLabel(getHeadingLabel(), "Generate password");
		lengthField = new JFormattedTextField();
		lengthLabel = new JLabel("Length of Password: ");
		
		
		lengthLabel.setLabelFor(lengthField);

		
		getFieldPanel().add(lengthField);
		getLabelPanel().add(lengthLabel);
		
		
		setupStatus();
		
	}
	


}
