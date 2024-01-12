package hospital_management_system;

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
	
	HashMap<String, String> loginInfoCopy = new HashMap<String, String>();
	
	public LoginPage(HashMap<String, String> login_passwords){
		
		loginInfoCopy = login_passwords;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 450);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
