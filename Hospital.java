/**
 * @file Hospital.java
 * @brief This file contains the Hospital class.
 */
package hospital_management_system;

import java.util.ArrayList;

/**
 * @class Hospital
 * @brief Represents the hospital.
 */
public class Hospital {
	
	// List of floors
	private ArrayList<HospitalFloor> floors = new ArrayList<HospitalFloor>();
	
	/**
	 * @method Hospital
     * @brief Constructs a new Hospital.
     * @param floors A list of floors in a hospital.
     */
	public Hospital(ArrayList<HospitalFloor> floors) {
		this.floors = floors;
	}
	
	/**
	 * @method getFloors
     * @brief Getter method for floors.
     * @return List of floors in a hospital.
     */
	public ArrayList<HospitalFloor> getFloors(){
		return floors;
	}

}
