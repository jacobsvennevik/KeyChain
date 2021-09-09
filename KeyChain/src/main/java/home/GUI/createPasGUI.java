package home.GUI;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import home.KeyChain.Chain;
import home.KeyChain.createFile;
import home.password.Cipher;
import home.password.Password;

public class createPasGUI extends JPanel implements ActionListener {
	
	private static JFrame frame; 
	private JPanel labelPanel, fieldPanel, downPanel, buttonPanel;
	private JLabel pasLabel1, pasLabel2, websiteLabel;
	private static JLabel statusLabel;
	private static JLabel statusMessage, headingLabel;
	private JButton returnButton, sendButton;
	private static String pasString1 = "Write password: ", pasString2 = "Write password again: ", websiteString = "Website: ";
	private static JFormattedTextField websiteField;
	private JPasswordField pasField1, pasField2;
	
	public createPasGUI() {	
			super(new BorderLayout());
			
			statusMessage = new JLabel();
			statusLabel = new JLabel("status: ");
			headingLabel = new JLabel();
			
			setHeadingLabel(headingLabel, "Create password");
			
			returnButton = new JButton("back");
			returnButton.addActionListener(this);
			sendButton = new JButton("send");
			sendButton.addActionListener(this);
			
			setFieldPanel(new JPanel(new GridLayout(0,1)));
			setLabelPanel(new JPanel(new GridLayout(0,1)));
			downPanel = new JPanel(new BorderLayout());
			buttonPanel = new JPanel(new BorderLayout());
			
			setWebsiteField(new JFormattedTextField());
			getWebsiteField().setColumns(10);
			
			websiteLabel = new JLabel(websiteString);
			
			websiteLabel.setLabelFor(getWebsiteField());
			
			getLabelPanel().add(websiteLabel);
			getFieldPanel().add(getWebsiteField());
			
			add(getLabelPanel(), BorderLayout.CENTER);
			add(getFieldPanel(), BorderLayout.LINE_END);
			add(downPanel, BorderLayout.PAGE_END);
			add(getHeadingLabel(), BorderLayout.PAGE_START);
			downPanel.add(buttonPanel, BorderLayout.PAGE_END);
			buttonPanel.add(returnButton, BorderLayout.LINE_START);
			buttonPanel.add(sendButton, BorderLayout.LINE_END);
			
			setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			
			setup();
			
			frame = new JFrame("Key chain");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.add(this);


			frame.pack();
			frame.setVisible(true);
		}




		public void setup() {

			
			pasField1 = new JPasswordField();
			pasField1.setColumns(10);
			
			pasField2 = new JPasswordField();
			pasField2.setColumns(10);
			
			getFieldPanel().add(pasField1);
			getFieldPanel().add(pasField2);
			
			setPasLabel1(new JLabel(pasString1));
			pasLabel2 = new JLabel(pasString2);

			
			
			getPasLabel1().setLabelFor(pasField2);
			pasLabel2.setLabelFor(pasField2);

			
			getLabelPanel().add(getPasLabel1());
			getLabelPanel().add(pasLabel2);
			
			setupStatus();
			

		}




		public void setupStatus() {
			statusLabel.setLabelFor(getStatusMessage());
			getFieldPanel().add(statusMessage);
			getLabelPanel().add(statusLabel);
			statusLabel.setVisible(false);
		}
	

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == returnButton) {
			new FinalGUI();
		}
		if(e.getSource() == sendButton) {
			compile();
		}

	}




	public void compile() {
		try {
			if (checkDuplicate()) {
				displayMessage("Password to this website already exists");
				return;
		}
			if(checkSamePas(pasField1, pasField2)) {
				createPas(getPasswodInfo(pasField1), getFieldInfo(websiteField));
				displayMessage("password successfully created");
			}
			else {
				displayMessage("Passwords not matching, try again");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}




	public Boolean checkDuplicate() throws Exception {
		return createFile.duplicatePasword(getFieldInfo(getWebsiteField()));
	}




	private String getPasswodInfo(JPasswordField field) {
		return String.valueOf(field.getPassword());
	}



	
	private static void createPas(String pas, String website) {
			try {
				Password p = new Password(pas, website);
				Cipher.encrypt(p, Cipher.randEncryption());
				createFile.writeFile(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}




	public static void displayMessage(String message) {
		statusLabel.setVisible(true);
		getStatusMessage().setText(message);
	}

	private boolean checkSamePas(JPasswordField pas1, JPasswordField pas2) {
		if(pas1.getPassword().length == 0 || pas2.getPassword().length == 0 ) {
			return false;
		}
		return Arrays.equals(pas1.getPassword(), pas2.getPassword());
		
	}


	public String getFieldInfo(JFormattedTextField field) {
		return field.getText();
	}

	public JPanel getFieldPanel() {
		return fieldPanel;
	}




	public void setFieldPanel(JPanel fieldPanel) {
		this.fieldPanel = fieldPanel;
	}




	public JPanel getLabelPanel() {
		return labelPanel;
	}




	public void setLabelPanel(JPanel labelPanel) {
		this.labelPanel = labelPanel;
	}




	public JLabel getPasLabel1() {
		return pasLabel1;
	}




	public void setPasLabel1(JLabel pasLabel1) {
		this.pasLabel1 = pasLabel1;
	}




	public static JFormattedTextField getWebsiteField() {
		return websiteField;
	}




	public static void setWebsiteField(JFormattedTextField websiteField) {
		createPasGUI.websiteField = websiteField;
	}




	public static JLabel getStatusMessage() {
		return statusMessage;
	}




	public static JLabel getHeadingLabel() {
		return headingLabel;
	}




	public static void setHeadingLabel(JLabel headingLabel, String string) {
		createPasGUI.headingLabel.setText(string);
	}
}
