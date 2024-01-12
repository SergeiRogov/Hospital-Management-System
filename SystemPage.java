package hospital_management_system;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SystemPage {
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel();
	
	SystemPage(String userLogin){
		
		welcomeLabel.setBounds(0, 0, 600, 25);
		welcomeLabel.setFont(new Font(null, Font.CENTER_BASELINE, 14));
		welcomeLabel.setText("Welcome to the Hospital Management System, " + userLogin + "!");
		
		frame.add(welcomeLabel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 550);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
}
