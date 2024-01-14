/**
 * @file OperatingRoom.java
 * @brief This file contains the OperatingRoom class.
 */
package hospital_management_system;

import java.util.ArrayList;

/**
 * @class OperatingRoom
 * @brief Represents the operating room in the hospital.
 */
public class OperatingRoom extends HospitalRoom {
	
	// array to cumulate all operating Rooms of hospital
	protected static ArrayList<OperatingRoom> operatingRooms = new ArrayList<>();

	/**
	 * @method OperatingRoom
     * @brief Constructs an Operating Room.
     * @param area Area of the room.
     * @param id Room ID.
     */
	public OperatingRoom(double area, String id) {
		super(area, "Operating", id);
		operatingRooms.add(this);
	}

	/**
	 * @method representAsString
     * @brief Makes a string representation of a class.
     * @return String representation.
     */
	@Override
	public String representAsString() {
		return "Operating room. ID: " + this.getRoomID() + " Area: " + (this.getArea() + "");
	}

}
