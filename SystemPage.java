/**
 * @file SystemPage.java
 * @brief This file contains the SystemPage class.
 */
package hospital_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @class SystemPage
 * @brief Represents the main page of the Hospital Management System.
 */
public class SystemPage extends JFrame implements ActionListener {
	
	// The serialVersionUID provides version control for serialized objects
	private static final long serialVersionUID = 1L;
	
	// File where system information is stored
	final static String DATABASE_FILE = "Hospital_Management_System-Database.txt";
	
	// List of Hospital patients
	private PatientList patientList;
	// Instance of Hospital
	private Hospital generalHospital;
	// Doctors
	private static ArrayList<Doctor> hospitalDoctors;
	
	// JPanel for drawing
	private JPanel drawingPanel; 
	
	//The main frame of the application
	JFrame frame = new JFrame();
	
	// welcoming label
	JLabel welcomeLabel = new JLabel();
	
	// addPatient - related elements
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
    
    // removePatient - related elements
    JLabel removePatientLabel = new JLabel("Remove patient by ID:");
	JLabel idLabel = new JLabel("ID:");
	JTextField idField = new JTextField();	
	JButton removePatientButton = new JButton("Remove patient");
	
	// elements for saving file
	JLabel saveBackupLabel = new JLabel("Save/backup:");
	JButton saveFileButton = new JButton("Save file");
	
	// backup elements
	JLabel filenameLabel = new JLabel("Backup to:");
	JLabel bakLabel = new JLabel(".bak");
	JTextField filenameField = new JTextField("Hospital Management System");
	JButton backupButton = new JButton("Backup file");
	
	// text area to display system information
	JTextArea roomInfoTextArea = new JTextArea();

	/**
	 * @method SystemPage
     * @brief Constructs a new SystemPage with the given user login.
     * 		  Instantiates all system-related objects and GUI.
     * @param userLogin The login of the user accessing the system.
     */
	public SystemPage(String userLogin){
		
		initializeHospital();
		initializeGUI(userLogin);
		
	}
	
	/**
	 * @method initializeHospital
     * @brief Initializes all necessary Hospital components.
     */
	private void initializeHospital() {
		
		// Defining array of rooms for each floor
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
		
		// Instantiating HospitalFloor objects
		HospitalFloor hospitalFloor1 = new HospitalFloor(1, roomsFloor1);
		HospitalFloor hospitalFloor2 = new HospitalFloor(2, roomsFloor2);
		HospitalFloor hospitalFloor3 = new HospitalFloor(3, roomsFloor3);
		
		ArrayList<HospitalFloor> floors = new ArrayList<>();
		
		// Array of floors
		floors.add(hospitalFloor1);
		floors.add(hospitalFloor2);
		floors.add(hospitalFloor3);
		
		generalHospital = new Hospital(floors);
		
		patientList = new PatientList();
		
		hospitalDoctors = new ArrayList<>();
		
		hospitalDoctors.add(new Doctor("House"));
		hospitalDoctors.add(new Doctor("Forman"));
		hospitalDoctors.add(new Doctor("Cameron"));
		hospitalDoctors.add(new Doctor("Chase"));
		
    }
	
	/**
	 * @method initializeGUI
     * @brief Initializes all necessary GUI elements. GUI setup logic.
     * @param userLogin The login of the user accessing the system.
     */
	private void initializeGUI(String userLogin) {
		
		// DocumentListener for text fields
		// Anonymous inner class
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
		
		// Parameters of addPatient - related elements
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
		
		// Parameters of removePatient - related elements
		removePatientLabel.setBounds(300, 45, 200, 25);
		removePatientLabel.setFont(new Font(null, Font.BOLD, 14));
		
		idLabel.setBounds(290, 120, 20, 20);
		
		idField.setBounds(310, 120, 180, 20);
		
		removePatientButton.setBounds(300, 210, 150, 25);
		removePatientButton.setFocusable(false);
		removePatientButton.addActionListener(this);
		
		// Parameters of save - related elements
		saveBackupLabel.setBounds(620, 45, 200, 25);
		saveBackupLabel.setFont(new Font(null, Font.BOLD, 14));
		
		saveFileButton.setBounds(620, 100, 100, 25);
		saveFileButton.setFocusable(false);
		saveFileButton.addActionListener(this);
		
		// Parameters of backup - related elements
		filenameLabel.setBounds(530, 170, 68, 25);
		filenameField.setBounds(598, 170, 210, 25);
		bakLabel.setBounds(808, 170, 50, 25);
		
		backupButton.setBounds(620, 210, 100, 25);
		backupButton.setFocusable(false);
		backupButton.addActionListener(this);
		
		// adding every element to a frame
		// adding addPatient - related elements
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
		
		// adding removePatient - related elements
		frame.add(removePatientLabel);
		frame.add(idLabel);
		frame.add(idField);
		frame.add(removePatientButton);
		
		// adding saveFile - related elements
		frame.add(saveBackupLabel);
		frame.add(saveFileButton);
		
		// adding backupFile - related elements
		frame.add(backupButton);
		frame.add(filenameLabel);
		frame.add(bakLabel);
		frame.add(filenameField);
		
		// Application will exit after user clicks close button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850, 620); // Dimensions of a frame
		frame.setLayout(null);
		frame.setVisible(true);
		
		// JPanel for drawing
		drawingPanel = new DrawingPanel(); 
        drawingPanel.setBounds(0, 0, 850, 700);
        frame.add(drawingPanel);
        
        // If database file exists - load system information from it
        Path filePath = Paths.get(DATABASE_FILE);
        if (Files.exists(filePath)) {
        	loadFromFile(DATABASE_FILE);
        }
        
        // enable/disable buttons
        updateButtonsState();

        // Add JTextArea for displaying room information
        roomInfoTextArea.setBounds(10, 270, 830, 300);
        roomInfoTextArea.setEditable(false);
        frame.add(roomInfoTextArea);

        // Update room information
        updateRoomInfo();
        
        // to make it visible initially
        roomInfoTextArea.selectAll();

    }

	/**
	 * @method updateRoomInfo
     * @brief Method to update room information in the JTextArea.
     */
    private void updateRoomInfo() {
    	// string for information display
        StringBuilder roomInfo = new StringBuilder();

        // Iterating over hospital floors
        for (HospitalFloor floor : generalHospital.getFloors()) {
            roomInfo.append("Floor ").append(floor.getLevel()).append(": \n");
            // Iterating over floor rooms
            for (HospitalRoom room : floor.getRooms()) {
                roomInfo.append("    Room ").append(room.getRoomID()).append(" (").append(room.getType()).append("):");

                if (room.getPatientList().isEmpty()) {
                	// Zero patients in a room
                    roomInfo.append(" Empty\n");
                } else {
                	// Iterating over patients in a room
                	for (Patient patient : room.getPatientList()) {
                		roomInfo.append(" Patient ").append(patient.toString()).append(",");
                	}
                	roomInfo.append("\n");
                }
            }
            roomInfo.append("\n");
        }
        // Put updated information into Text Area
        roomInfoTextArea.setText(roomInfo.toString());
    }
    
    /**
	 * @method updateButtonsState
     * @brief Updates the state of buttons based on text field contents.
     */
    private void updateButtonsState() {
        boolean isAddButtonEnabled = !nameField.getText().isEmpty() &&
                !surnameField.getText().isEmpty() &&
                !illnessField.getText().isEmpty();
        
        // enable only if all fields related to AddButton are filled
        addPatientButton.setEnabled(isAddButtonEnabled);

        boolean isRemoveButtonEnabled = !idField.getText().isEmpty();
        // enable only if idField is filled
        removePatientButton.setEnabled(isRemoveButtonEnabled);
        
        boolean isBackupButtonEnabled = !filenameField.getText().isEmpty();
        // enable only if filenameField is filled
        backupButton.setEnabled(isBackupButtonEnabled);
    }
    
    /**
	 * @method loadFromFile
     * @brief Loads information from the database file and
     * 		  instantiates corresponding data structures.
     * @param fileName Database filename.
     */
    private void loadFromFile(String fileName) {
    	// Read from .txt file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            
            String line;
            // Read line by line
            while ((line = reader.readLine()) != null) {
            	
            	String[] values = line.split(";");
            	// lines from second and further - patients info
            	if (values.length == 6) {
                    String patientID = values[0];
                    String name = values[1];
                    String surname = values[2];
                    String illness = values[3];
                    String roomID = values[4];
                    String doctorName = values[5];
                    
                    HospitalRoom roomToAssign = null;
                    // Find the room of patient by room id
                    for (HospitalFloor floor : generalHospital.getFloors()) { 
                        for (HospitalRoom room : floor.getRooms()) {
                        	if (room.getRoomID().equals(roomID)) {
                        		roomToAssign = room;
                        		break;
                        	}
                        }
                    }
                    Doctor doctorToAssign = null;
                    for (Doctor doctor : hospitalDoctors) {
                    	if (doctor.getName().equals(doctorName)) {
                    		doctorToAssign = doctor;
                    		break;
                    	}
                    }
                    // If room not found - assign to the first room on the third floor
                    // (roomToAssign should NOT be null unless someone manually modified the
                    // records in file or information about rooms in the hospital was changed)
                    if (roomToAssign == null) {
                    	roomToAssign = generalHospital.getFloors().get(2).getRooms().get(0);
                    }
                    
                    // The same for a doctor
                    if (doctorToAssign == null) {
                    	doctorToAssign = hospitalDoctors.get(0);
                    }
                    
                    Patient patient = new Patient(patientID, name, surname, illness, roomToAssign, doctorToAssign);
                    
                    // Add extracted patient to the list of Patients of whole Hospital
                    patientList.addPatient(patient);
                    // Add extracted patient to the list of Patients of exact Room
                    roomToAssign.addPatient(patient);
                    // Add extracted patient to the list of Patients of exact Doctor
                    doctorToAssign.addPatient(patient);
                // first line - total number of patients ever entered into system
                } else if (values.length == 1) {
                	int patientCount = Integer.parseInt(values[0]);
                	Patient.setPatientCount(patientCount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * @method createFileIfNotExists
     * @brief Function to create a file if it does not exist yet.
     * @param fileName Name of the database file.
     */
    private static void createFileIfNotExists(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File " + fileName + " will be updated");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
    
    /**
	 * @method findRoomWithSmallestPatientList
     * @brief Function to find the HospitalRoom with the smallest PatientList.
     * @param hospitalRooms Upcasted array of hospital rooms.
     * @return Room with smallest number of patients.
     */
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
        
        // If all rooms are empty - return the first one
        if (smallestRoom == null) {
    		smallestRoom = hospitalRooms.get(0);
    	}
        
        // Return the Room with smallest number of patients in it.
        return smallestRoom;
    }

    /**
     * @class DrawingPanel
     * @brief Custom JPanel for drawing.
     */
    private class DrawingPanel extends JPanel {
    	
    	// The serialVersionUID provides version control for serialized objects
    	private static final long serialVersionUID = 1L;
    	
    	/**
    	 * @method paintComponent
         * @brief Draws black lines to separate elements.
         * @param g The Graphics context used for drawing.
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // Set color to black
            g.setColor(Color.BLACK);
            
            // Horizontal upper separating line
            g.drawLine(0, 40, 850, 40); 
            
            // Vertical lines separating left, middle and right sections
            g.drawLine(260, 40, 260, 260);
            g.drawLine(510, 40, 510, 260);
            
            // Horizontal line separating actions section from information section
            g.drawLine(0, 260, 850, 260);  

        }
    }
    
    /**
     * @method getRandomIndex
     * @brief computes random number between 0 (inclusive) and the length of the array (exclusive).
     * @param arrayLength Length of array.
     * @return Number from 0 to arrayLength.
     */
    private static int getRandomIndex(int arrayLength) {
        Random random = new Random();
        return random.nextInt(arrayLength);
    }

    /**
     * @method actionPerformed
     * @brief Handles action events for various buttons in the Hospital Management System GUI.
     * @param e The ActionEvent representing the button click or action.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// addPatient button functionality
		if(e.getSource()==addPatientButton) {
			
			String name = nameField.getText();
			String surname = surnameField.getText();
			String illness = illnessField.getText();
			HospitalRoom smallestRoom;
			
			// Assign a room based on selected room type
			// find a room with smallest number of patients among selected room type
	        if (radioButton1.isSelected()) {
	        	smallestRoom = findRoomWithSmallestPatientList(MedicalRoom.medicalRooms);
	        } else if (radioButton2.isSelected()) {
	        	smallestRoom = findRoomWithSmallestPatientList(IntensiveCareRoom.intensiveCareRooms);
	        } else if (radioButton3.isSelected()) {
	        	smallestRoom = findRoomWithSmallestPatientList(OperatingRoom.operatingRooms);
	        } else {
	        	// Default
	        	smallestRoom = findRoomWithSmallestPatientList(MedicalRoom.medicalRooms);
	        }
			
			Patient patient = new Patient(name, surname, illness);
			patient.setRoom(smallestRoom);
			
			Doctor assignedDoctor = hospitalDoctors.get(getRandomIndex(hospitalDoctors.size()));
			patient.setDoctor(assignedDoctor);
			
			// Add new patient to the necessary arrays of patients
			// 1) to the list of Patients of whole Hospital
			// 2) to the list of Patients of exact Room
			// 3) to the list of Patients of exact Doctor
			patientList.addPatient(patient);
			smallestRoom.addPatient(patient);
			assignedDoctor.addPatient(patient);
			updateRoomInfo();
			// Show info message
	        JOptionPane.showMessageDialog(frame, "New patient is added.", "Message", JOptionPane.INFORMATION_MESSAGE);
	        
	        // Reset text fields
			nameField.setText("");
			surnameField.setText("");
			illnessField.setText("");
			
		}

		// removePatient button functionality
		if(e.getSource()==removePatientButton) {
			
			Patient patientToDelete = null;
			String idToDelete = idField.getText();
			ArrayList<Patient> patients = patientList.getPatientList();
			
			HospitalRoom roomWithPatient = null;
			
			// Find patient by ID in one of Rooms
			for(HospitalFloor floor : generalHospital.getFloors()) {
				for(HospitalRoom room : floor.getRooms()) {
	        		ArrayList<Patient> roomPatients = room.getPatientList();
	        		for(Patient patient : roomPatients) {
	        			if(patient.getID().equals(idToDelete)) {
	        				patientToDelete = patient;
	        				roomWithPatient = room;
	        				break;
						}
	        		}
				}
			}
			
			if (patientToDelete == null) {
		        // No patient with such ID
				// Appropriate message is displayed in another code block
				// No code needed
		    } else {
		    	// remove patient from this room
		    	roomWithPatient.removePatient(patientToDelete);
		    }
			
			// Find patient by ID in array of patients
			patientToDelete = null;
			for(Patient patient : patients) {
				if(patient.getID().equals(idToDelete)) {
					patientToDelete = patient;
					break;
				}
			}
			
			// Appropriate messages
			if (patientToDelete == null) {
				String message = "Patient " + idToDelete + " is not found.";
				JOptionPane.showMessageDialog(frame, message, "Message", JOptionPane.INFORMATION_MESSAGE);
			} else {
				String message = "Patient " + idToDelete + " is removed.";
				// remove patient from patients array
				patientList.removePatient(patientToDelete);
				// update information
				updateRoomInfo();
				JOptionPane.showMessageDialog(frame, message, "Message", JOptionPane.INFORMATION_MESSAGE);
			}

			// reset text field
			idField.setText("");
		}
		
		// save file button functionality
		if(e.getSource()==saveFileButton) {
			String fileName = "Hospital_Management_System-Database.txt";

	        // Create the file if it doesn't exist
	        createFileIfNotExists(fileName);
	        
	        // write to database file
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	        	
	        	// first line - total number of patients ever added to a system
	        	writer.write(Patient.getPatientCount() + "");
	        	writer.newLine(); // Add a newline character to separate lines	
	            
	        	// line by line, information about patients
	            for (Patient patient : patientList.getPatientList()) {
	                writer.write(patient.stringToFile());
	                writer.newLine(); // Add a newline character to separate lines
	            }
	         // info messages
	            System.out.println("File: " + fileName + " has been updated");
	            JOptionPane.showMessageDialog(frame, "Data is saved.", "Message", JOptionPane.INFORMATION_MESSAGE);
	        } catch (IOException exception) {
	            // Handle IOException if there is an issue with file I/O
	        	exception.printStackTrace();
	        }
		}
		
		// backup functionality
		if(e.getSource()==backupButton) {
			String fileName = filenameField.getText();
			fileName = fileName + ".bak";
			
	        // Create the file if it doesn't exist
	        createFileIfNotExists(fileName);
	        
	        // write to backup file
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	        	
	        	// first line - total number of patients ever added to a system
	        	writer.write(Patient.getPatientCount() + "");
	        	writer.newLine(); // Add a newline character to separate lines	
	            
	        	// line by line, information about patients
	            for (Patient patient : patientList.getPatientList()) {
	                writer.write(patient.stringToFile());
	                writer.newLine(); // Add a newline character to separate lines
	            }
	            // info messages
	            String message = "Data is backed up to file " + fileName;
	            System.out.println("Data has been backed up to the file: " + fileName);
	            JOptionPane.showMessageDialog(frame, message, "Message", JOptionPane.INFORMATION_MESSAGE);
	        } catch (IOException exception) {
	            // Handle IOException if there is an issue with file I/O
	        	exception.printStackTrace();
	        }
			filenameField.setText("Hospital Management System");
		}
	}
}
