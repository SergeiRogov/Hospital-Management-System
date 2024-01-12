package hospital_management_system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SystemPage implements ActionListener {
	
	JFrame frame = new JFrame();
	
	JLabel welcomeLabel = new JLabel();
	
	JLabel addPatientLabel = new JLabel("Add new patient:");
	
	JLabel nameLabel = new JLabel("Name:");
	JLabel surnameLabel = new JLabel("Surname:");
	JLabel illnessLabel = new JLabel("Illness:");
	JLabel roomLabel = new JLabel("Room:");
	
	JTextField nameField = new JTextField();	
	JTextField surnameField = new JTextField();	
	JTextField illnessField = new JTextField();	
	
	JRadioButton radioButton1 = new JRadioButton("Medical");
    JRadioButton radioButton2 = new JRadioButton("Intensive Care");
    JRadioButton radioButton3 = new JRadioButton("Operating");
    
    JButton addPatientButton = new JButton("Add patient");
	
	SystemPage(String userLogin){
		
		welcomeLabel.setBounds(440, 5, 600, 25);
		welcomeLabel.setFont(new Font(null, Font.CENTER_BASELINE, 14));
		welcomeLabel.setText("Welcome to the Hospital Management System, " + userLogin + "!");
		
		addPatientLabel.setBounds(60, 45, 200, 25);
		addPatientLabel.setFont(new Font(null, Font.BOLD, 14));
		
		nameLabel.setBounds(10, 80, 80, 20);
		surnameLabel.setBounds(10, 100, 80, 20);
		illnessLabel.setBounds(10, 120, 80, 20);
		roomLabel.setBounds(10, 140, 80, 20);
		
		nameField.setBounds(90, 80, 150, 20);
		surnameField.setBounds(90, 100, 150, 20);
		illnessField.setBounds(90, 120, 150, 20);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(radioButton1);
	    group.add(radioButton2);
	    group.add(radioButton3);
		
		radioButton1.setBounds(90, 140, 150, 20);
		radioButton2.setBounds(90, 160, 150, 20);
		radioButton3.setBounds(90, 180, 150, 20);
		
		addPatientButton.setBounds(60, 210, 100, 25);
		addPatientButton.setFocusable(false);
		addPatientButton.addActionListener(this);
		
		frame.add(welcomeLabel);
		
		frame.add(addPatientLabel);
		
		frame.add(nameLabel);
		frame.add(surnameLabel);
		frame.add(illnessLabel);
		frame.add(roomLabel);
		
		frame.add(nameField);
		frame.add(surnameField);
		frame.add(illnessField);
		
		frame.add(radioButton1);
		frame.add(radioButton2);
		frame.add(radioButton3);
		
		frame.add(addPatientButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 700);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// reset button functionality
		if(e.getSource()==addPatientButton) {
			
		}
		
	}
}
