/**
 * @file IntensiveCareRoom.java
 * @brief This file contains the IntensiveCareRoom class.
 */
package hospital_management_system;

import java.util.ArrayList;

/**
 * @class HospitalFloor
 * @brief Represents the intensive care room in the hospital.
 */
public class IntensiveCareRoom extends HospitalRoom {
	
	// array to cumulate all intensive care Rooms of hospital
	protected static ArrayList<IntensiveCareRoom> intensiveCareRooms = new ArrayList<>();

	/**
	 * @method IntensiveCareRoom
     * @brief Constructs an Intensive Care Room.
     * @param area Area of the room.
     * @param id Room ID.
     */
	public IntensiveCareRoom(double area, String id) {
		super(area, "Intensive Care", id);
		intensiveCareRooms.add(this);
	}

}
