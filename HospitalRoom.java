package hospital_management_system;

import java.util.ArrayList;

public abstract class HospitalRoom {
	
	private double area;
	private String type;
	private String roomID;
	private ArrayList<HospitalEquipment> equipmentItems = new ArrayList<HospitalEquipment>();
	private ArrayList<Patient> roomPatients = new ArrayList<Patient>();
	
	public HospitalRoom(double area, String type, String roomID) {
		this.area = area;
		this.type = type;
		this.roomID = roomID;
	}
	
	public void addPatient(Patient patient) {
		roomPatients.add(patient);
	}
	
	public String getRoomID() {
		return this.roomID;
	}
	
	public ArrayList<Patient> getPatientList(){
		return roomPatients;
	}

}
