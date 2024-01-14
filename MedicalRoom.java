/**
 * @file MedicalRoom.java
 * @brief This file contains the MedicalRoom class.
 */
package hospital_management_system;

import java.util.ArrayList;

/**
 * @class MedicalRoom
 * @brief Represents the medical room in the hospital.
 */
public class MedicalRoom extends HospitalRoom {
	
	// array to cumulate all medical Rooms of hospital
	protected static ArrayList<MedicalRoom> medicalRooms = new ArrayList<>();

	/**
	 * @method MedicalRoom
     * @brief Constructs a Medical Room.
     * @param area Area of the room.
     * @param id Room ID.
     */
	public MedicalRoom(double area, String id) {
		super(area, "Medical", id);
		medicalRooms.add(this);
	}
	
}
