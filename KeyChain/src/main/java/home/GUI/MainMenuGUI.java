package home.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;



public class MainMenuGUI implements ActionListener {
	
	private JButton createPasswordButton, generatePasswordButton, getPasswordButton;
	private JFrame frame;

	public MainMenuGUI() {
		frame = setupFrame("Main menu");

		JPanel buttons = setupButtons();
		
		frame.add(buttons);
		frame.setVisible(true);
		
	}


	private JPanel setupButtons() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		generatePasswordButton = addButton(buttons, "Generate password");
		createPasswordButton = addButton(buttons, "Create password");
		getPasswordButton = addButton(buttons, "Find password");
		return buttons;
	}
	
	public JPanel createPanel(JPanel name) {
		name = new JPanel();
		name.setLayout(new BorderLayout());
		return name;
	}



	JButton addButton(JPanel buttons, String name) {
		JButton button = new JButton();
		button.setText(name);
		button.setFont(new Font("Arial", Font.PLAIN, 40));
		button.addActionListener(this);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttons.add(Box.createRigidArea(new Dimension(20, 20)));
		buttons.add(button);
		return button;
	}
	
	
    public static void main(String[] args) {
		new MainMenuGUI();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == createPasswordButton) {
			new CreatePasGUI();
			
		}
		if(e.getSource() == generatePasswordButton) {
			new GeneratePasGUI();
		}
		if(e.getSource() == getPasswordButton ) {
			new getPasswordGUI();
		}
		frame.dispose();
		
		
		
	}


	public JFrame setupFrame(String name) {
		frame = new JFrame();
		frame.setTitle(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setPreferredSize(new Dimension(1000, 1000));
		return frame;
	}

}
