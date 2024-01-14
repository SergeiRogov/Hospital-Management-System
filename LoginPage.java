/**
 * @file LoginPage.java
 * @brief This file contains the LoginPage class.
 */
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

/**
 * @class LoginPage
 * @brief Represents the login page of the Hospital Management System.
 */
public class LoginPage implements ActionListener {
	
	// Frame elements
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField loginField = new JTextField();	
	JPasswordField passwordField = new JPasswordField();
	JLabel loginLabel = new JLabel("Login:");
	JLabel passwordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel();
	JLabel titleLabel = new JLabel("Hospital Management System");
	
	// Used as copy of original login-password HashMap
	private HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	/**
	 * @method LoginPage
     * @brief Constructs a new LoginPage with the given login info.
     * @param login_passwords The login information.
     */
	public LoginPage(HashMap<String, String> login_passwords){
		
		// copy login information
		loginInfo = login_passwords;
		
		// Locate elements across the frame
		titleLabel.setBounds(110, 35, 300, 25);
		titleLabel.setFont(new Font(null, Font.BOLD, 15));
		
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
		
		// Add all elements to a frame
		frame.add(loginLabel);
		frame.add(passwordLabel);
		frame.add(messageLabel);
		frame.add(titleLabel);
		
		frame.add(loginField);
		frame.add(passwordField);
		
		frame.add(loginButton);
		frame.add(resetButton);

		// Application will exit after user clicks close button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 350); // Dimensions of a frame
		frame.setLayout(null);
		frame.setVisible(true);
	}

	/**
     * @method actionPerformed
     * @brief Handles action events for various buttons in the Hospital Management System GUI.
     * @param e The ActionEvent representing the button click or action.
     */
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
			// if login exists
			if (loginInfo.containsKey(userLogin)) {
				// if password is correct
				if (loginInfo.get(userLogin).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("You are logged in!");
					// get rid of login page
					frame.dispose();
					// instantiate Hospital Management System page
					SystemPage systemPage = new SystemPage(userLogin);
				// corresponding messages
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
