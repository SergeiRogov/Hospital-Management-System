/**
 * @file HospitalRoom.java
 * @brief This file contains the HospitalRoom class.
 */
package hospital_management_system;

import java.util.ArrayList;

/**
 * @class HospitalRoom
 * @brief Represents the room in the hospital.
 */
public abstract class HospitalRoom {
	
	// Room attributes
	private double area;
	private String type;
	private String roomID;
	private ArrayList<Patient> roomPatients = new ArrayList<Patient>();
	
	/**
	 * @method HospitalRoom
     * @brief Constructs a new HospitalRoom.
     * @param area Area of a room.
     * @param type Type of a room.
     * @param roomID Room identification number.
     */
	public HospitalRoom(double area, String type, String roomID) {
		this.area = area;
		this.type = type;
		this.roomID = roomID;
	}
	
	/**
	 * @method addPatient
     * @brief Adds a new patient to the room.
     * @param patient Patient to be added.
     */
	public void addPatient(Patient patient) {
		roomPatients.add(patient);
	}
	
	/**
	 * @method removePatient
     * @brief Removes patient from PatientList.
     * @param patient Patient to be removed.
     */
	public void removePatient(Patient patient) {
		roomPatients.remove(patient);
	}
	
	/**
	 * @method getRoomID
     * @brief Getter method for a roomID.
     * @return Room ID.
     */
	public String getRoomID() {
		return this.roomID;
	}
	
	/**
	 * @method getType
     * @brief Getter method for a type.
     * @return Room type.
     */
	public String getType() {
		return this.type;
	}
	
	/**
	 * @method getArea
     * @brief Getter method for area.
     * @return Room area in square meters.
     */
	public double getArea() {
		return this.area;
	}
	
	/**
	 * @method getPatientList
     * @brief Getter method for a PatientList.
     * @return List of patients.
     */
	public ArrayList<Patient> getPatientList(){
		return roomPatients;
	}
	
	/**
	 * @method representAsString
     * @brief Makes a string representation of a class.
     * @return String representation.
     */
	public abstract String representAsString();
}
