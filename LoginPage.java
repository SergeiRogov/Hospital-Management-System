package hospital_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField loginField = new JTextField();	
	JPasswordField passwordField = new JPasswordField();
	JLabel loginLabel = new JLabel("Login:");
	JLabel passwordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel();
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	public LoginPage(HashMap<String, String> login_passwords){
		
		loginInfo = login_passwords;
		
		loginLabel.setBounds(50, 100, 75, 25);
		passwordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(140, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.BOLD, 20));
		 
		loginField.setBounds(125, 100, 200, 25);
		passwordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225, 200, 100, 25);
		loginButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(loginLabel);
		frame.add(passwordLabel);
		frame.add(messageLabel);
		
		frame.add(loginField);
		frame.add(passwordField);
		
		frame.add(loginButton);
		frame.add(resetButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 450);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		// reset button functionality
		if(e.getSource()==resetButton) {
			loginField.setText("");
			passwordField.setText("");
		}
		
		// login button functionality
		if(e.getSource()==loginButton) {
			String userLogin = loginField.getText();
			String password = String.valueOf(passwordField.getPassword());
			
			if (loginInfo.containsKey(userLogin)) {
				if (loginInfo.get(userLogin).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("You are logged in!");
					
					SystemPage systemPage = new SystemPage();
				} else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password!");
				}
			} else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Login not found!");
			}
		}
		
	}

}
