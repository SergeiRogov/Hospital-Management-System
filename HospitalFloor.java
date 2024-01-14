/**
 * @file HospitalFloor.java
 * @brief This file contains the HospitalFloor class.
 */
package hospital_management_system;

import java.util.ArrayList;

/**
 * @class HospitalFloor
 * @brief Represents the floor of the hospital.
 */
public class HospitalFloor {
	
	// floor index
	private int level; 
	// list of rooms on a floor
	private ArrayList<HospitalRoom> rooms = new ArrayList<HospitalRoom>(); 
	
	/**
	 * @method HospitalFloor
     * @brief Constructs a new HospitalFloor with the given level and list of rooms.
     * @param level Floor index, starting from 1.
     * @param rooms A list of rooms on a floor.
     */
	public HospitalFloor(int level, ArrayList<HospitalRoom> rooms) {
		this.level = level;
		this.rooms = rooms;
	}
	
	/**
	 * @method getRooms
     * @brief Getter method for a list of rooms.
     * @return rooms A list of rooms on a floor.
     */
	public ArrayList<HospitalRoom> getRooms(){
		return rooms;
	}
	
	/**
	 * @method getLevel
     * @brief Getter method for an index of the floor.
     * @return rooms A list of rooms on a floor.
     */
	public int getLevel(){
		return this.level;
	}
}
