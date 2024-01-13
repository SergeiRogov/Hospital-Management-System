package hospital_management_system;

import java.util.ArrayList;

public class HospitalFloor {
	
	private int level;
	
	private ArrayList<HospitalRoom> rooms = new ArrayList<HospitalRoom>();
	
	public HospitalFloor(int level, ArrayList<HospitalRoom> rooms) {
		this.level = level;
		this.rooms = rooms;
	}
	
	public ArrayList<HospitalRoom> getRooms(){
		return rooms;
	}
	
	public int getLevel(){
		return this.level;
	}
}
