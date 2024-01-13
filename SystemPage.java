package hospital_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SystemPage extends JFrame implements ActionListener {
	
	private PatientList patientList;
	private Hospital generalHospital;
	
	// JPanel for drawing
	private JPanel drawingPanel; 
	
	JFrame frame = new JFrame();
	// welcoming label
	JLabel welcomeLabel = new JLabel();
	
	// add patient - related elements
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
    
    // remove patient - related elements
    JLabel removePatientLabel = new JLabel("Remove patient by ID:");
	JLabel idLabel = new JLabel("ID:");
	JTextField idField = new JTextField();	
	JButton removePatientButton = new JButton("Remove patient");
	
	// button for saving file
	JLabel saveBackupLabel = new JLabel("Save/backup:");
	JButton saveFileButton = new JButton("Save file");
	
	// backup elements
	JLabel filenameLabel = new JLabel("Backup to:");
	JLabel bakLabel = new JLabel(".bak");
	JTextField filenameField = new JTextField("Hospital Management System");
	JButton backupButton = new JButton("Backup file");

	SystemPage(String userLogin){
		
		ArrayList<HospitalRoom> roomsFloor1 = new ArrayList<>();
		ArrayList<HospitalRoom> roomsFloor2 = new ArrayList<>();
		ArrayList<HospitalRoom> roomsFloor3 = new ArrayList<>();
		
		// Instantiating all existing rooms in General Hospital
		// First floor
		roomsFloor1.add(new OperatingRoom(30, "101"));
		roomsFloor1.add(new OperatingRoom(50, "102"));
		roomsFloor1.add(new OperatingRoom(40, "103"));
		roomsFloor1.add(new IntensiveCareRoom(40, "104"));
		roomsFloor1.add(new MedicalRoom(22, "105"));
		
		// Second floor
		roomsFloor2.add(new IntensiveCareRoom(30, "201"));
		roomsFloor2.add(new IntensiveCareRoom(35, "202"));
		roomsFloor2.add(new IntensiveCareRoom(40, "203"));
		roomsFloor2.add(new MedicalRoom(30, "204"));
		
		// Third floor
		roomsFloor3.add(new MedicalRoom(15, "301"));
		roomsFloor3.add(new MedicalRoom(20, "302"));
		roomsFloor3.add(new MedicalRoom(17, "303"));
		roomsFloor3.add(new IntensiveCareRoom(20, "304"));
		
		HospitalFloor hospitalFloor1 = new HospitalFloor(1, roomsFloor1);
		HospitalFloor hospitalFloor2 = new HospitalFloor(2, roomsFloor2);
		HospitalFloor hospitalFloor3 = new HospitalFloor(3, roomsFloor3);
		
		ArrayList<HospitalFloor> floors = new ArrayList<>();
	
		floors.add(hospitalFloor1);
		floors.add(hospitalFloor2);
		floors.add(hospitalFloor3);
		
		generalHospital = new Hospital(floors);
		
		// DocumentListener for text fields
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateButtonsState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateButtonsState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateButtonsState();
            }
        };
        
        // Add DocumentListener to text fields
        nameField.getDocument().addDocumentListener(documentListener);
        surnameField.getDocument().addDocumentListener(documentListener);
        illnessField.getDocument().addDocumentListener(documentListener);
        idField.getDocument().addDocumentListener(documentListener);
        filenameField.getDocument().addDocumentListener(documentListener);
		
		// welcoming label
		welcomeLabel.setBounds(230, 5, 600, 25);
		welcomeLabel.setFont(new Font(null, Font.CENTER_BASELINE, 14));
		welcomeLabel.setText("Welcome to the Hospital Management System, " + userLogin + "!");
		
		// add patient - related elements
		addPatientLabel.setBounds(55, 45, 200, 25);
		addPatientLabel.setFont(new Font(null, Font.BOLD, 14));
		
		nameLabel.setBounds(10, 80, 70, 20);
		surnameLabel.setBounds(10, 100, 70, 20);
		illnessLabel.setBounds(10, 120, 70, 20);
		roomLabel.setBounds(10, 140, 70, 20);
		
		nameField.setBounds(80, 80, 150, 20);
		surnameField.setBounds(80, 100, 150, 20);
		illnessField.setBounds(80, 120, 150, 20);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(radioButton1);
	    group.add(radioButton2);
	    group.add(radioButton3);
		
		radioButton1.setBounds(80, 143, 150, 20);
		radioButton1.setSelected(true);
		radioButton2.setBounds(80, 163, 150, 20);
		radioButton3.setBounds(80, 183, 150, 20);
		
		addPatientButton.setBounds(60, 210, 100, 25);
		addPatientButton.setFocusable(false);
		addPatientButton.addActionListener(this);
		
		// remove patient - related elements
		removePatientLabel.setBounds(300, 45, 200, 25);
		removePatientLabel.setFont(new Font(null, Font.BOLD, 14));
		
		idLabel.setBounds(290, 120, 20, 20);
		
		idField.setBounds(310, 120, 180, 20);
		
		removePatientButton.setBounds(300, 210, 150, 25);
		removePatientButton.setFocusable(false);
		removePatientButton.addActionListener(this);
		
		// save - related elements
		saveBackupLabel.setBounds(620, 45, 200, 25);
		saveBackupLabel.setFont(new Font(null, Font.BOLD, 14));
		
		saveFileButton.setBounds(620, 100, 100, 25);
		saveFileButton.setFocusable(false);
		saveFileButton.addActionListener(this);
		
		// backup - related elements
		filenameLabel.setBounds(530, 170, 68, 25);
		filenameField.setBounds(598, 170, 210, 25);
		bakLabel.setBounds(808, 170, 50, 25);
		
		backupButton.setBounds(620, 210, 100, 25);
		backupButton.setFocusable(false);
		backupButton.addActionListener(this);
		
		// adding every element to a frame
		// adding add patient - related elements
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
		
		// adding remove patient - related elements
		frame.add(removePatientLabel);
		frame.add(idLabel);
		frame.add(idField);
		frame.add(removePatientButton);
		
		// adding save File Button - related elements
		frame.add(saveBackupLabel);
		frame.add(saveFileButton);
		
		// adding backup File Button - related elements
		frame.add(backupButton);
		frame.add(filenameLabel);
		frame.add(bakLabel);
		frame.add(filenameField);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850, 700);
		frame.setLayout(null);
		frame.setVisible(true);
		
		drawingPanel = new DrawingPanel(); // Create a JPanel for drawing
        drawingPanel.setBounds(0, 0, 850, 700); // Set the bounds of the drawing panel
        frame.add(drawingPanel);
		
		// Initial state of buttons
        updateButtonsState();
        
        patientList = new PatientList();
	}
	
	// Create a custom JPanel for drawing
    private class DrawingPanel extends JPanel{
    	private static final long serialVersionUID = 1L;
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Black lines to separate elements
            g.setColor(Color.BLACK);
            
            // Horizontal separating line
            g.drawLine(0, 40, 850, 40); 
            
            // Vertical lines separating left, middle and right sections
            g.drawLine(260, 40, 260, 260);
            g.drawLine(510, 40, 510, 260);
            
            // Horizontal line separating actions section from information section
            g.drawLine(0, 260, 850, 260);  

        }
    }
	
	// Update the state of buttons based on text field contents
    private void updateButtonsState() {
        boolean isAddButtonEnabled = !nameField.getText().isEmpty() &&
                !surnameField.getText().isEmpty() &&
                !illnessField.getText().isEmpty();

        addPatientButton.setEnabled(isAddButtonEnabled);

        boolean isRemoveButtonEnabled = !idField.getText().isEmpty();
        removePatientButton.setEnabled(isRemoveButtonEnabled);
        
        boolean isBackupButtonEnabled = !filenameField.getText().isEmpty();
        backupButton.setEnabled(isBackupButtonEnabled);
    }
    
    // Function to find the HospitalRoom with the smallest PatientList
    private static HospitalRoom findRoomWithSmallestPatientList(ArrayList<? extends HospitalRoom> hospitalRooms) {
    	HospitalRoom smallestRoom = null;
        int smallestSize = Integer.MAX_VALUE;

        for (HospitalRoom room : hospitalRooms) {
            int currentSize = room.getPatientList().size(); 

            if (currentSize < smallestSize) {
                smallestSize = currentSize;
                smallestRoom = room;
            }
        }

        return smallestRoom;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// addPatient button functionality
		if(e.getSource()==addPatientButton) {

			String name = nameField.getText();
			String surname = surnameField.getText();
			String illness = illnessField.getText();
			String roomid;
			HospitalRoom smallestRoom;
			
			String roomType;
			// Assign a room based on selected room type
	        if (radioButton1.isSelected()) {
	        	roomType = "Medical";
	        } else if (radioButton2.isSelected()) {
	        	roomType = "Intensive Care";
	        } else if (radioButton3.isSelected()) {
	        	roomType = "Operating";
	        } else {
	        	// Default
	        	roomType = "Medical";
	        }
	        
	        switch (roomType) {
	        case "Medical":
	        	smallestRoom = findRoomWithSmallestPatientList(MedicalRoom.medicalRooms);
	        	if (smallestRoom == null) {
	        		roomid = MedicalRoom.medicalRooms.get(0).getRoomID();
	        	}
	        	roomid = smallestRoom.getRoomID();
	            break;
	        case "Intensive Care":
	        	smallestRoom = findRoomWithSmallestPatientList(IntensiveCareRoom.intensiveCareRooms);
	        	if (smallestRoom == null) {
	        		roomid = IntensiveCareRoom.intensiveCareRooms.get(0).getRoomID();
	        	} else
	        		roomid = smallestRoom.getRoomID();
	            break;
	        case "Operating":
	        	smallestRoom = findRoomWithSmallestPatientList(OperatingRoom.operatingRooms);
	        	if (smallestRoom == null) {
	        		roomid = OperatingRoom.operatingRooms.get(0).getRoomID();
	        	} else
	        		roomid = smallestRoom.getRoomID();
	            break;
	        default:
	        	smallestRoom = findRoomWithSmallestPatientList(MedicalRoom.medicalRooms);
	        	if (smallestRoom == null) {
	        		roomid = MedicalRoom.medicalRooms.get(0).getRoomID();
	        	} else
	        		roomid = smallestRoom.getRoomID();
	            break;
	        }  
			
			Patient patient = new Patient(name, surname, illness);
			patient.setRoomId(roomid);
			
			patientList.addPatient(patient);
			smallestRoom.addPatient(patient);
			
//			System.out.println("---------");
//	        for(HospitalFloor floor : generalHospital.getFloors()) {
//	        	System.out.println("FLOOR " + floor.getLevel());
//	        	for(HospitalRoom room : floor.getRooms()) {
//	        		System.out.println("ROOM " + room.getRoomID() + " " + room.getType());
//		        	for(Patient patien : room.getPatientList()) {
//		        		System.out.println(patien);
//		        	}
//				}
//			}
	        
	        System.out.println("---------");
	       
        	for(Patient patien : patientList.getPatientList()) {
        		System.out.println(patien);
        	}
		
			
			nameField.setText("");
			surnameField.setText("");
			illnessField.setText("");
		}

		// removePatient button functionality
		if(e.getSource()==removePatientButton) {
			// to do
			idField.setText("");
		}
		
		// save file button functionality
		if(e.getSource()==saveFileButton) {
			// to do
		}
		
		// backup functionality
		if(e.getSource()==backupButton) {
			// to do
			filenameField.setText("Hospital Management System");
		}
		
	}
}
