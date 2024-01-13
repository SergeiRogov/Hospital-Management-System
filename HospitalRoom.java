package hospital_management_system;

import java.util.ArrayList;

public abstract class HospitalRoom {
	
	private double area;
	private String type;
	private String roomID;
	private ArrayList<HospitalEquipment> equipmentItems;
	
	
	public HospitalRoom(double area, String type, String roomID) {
		this.area = area;
		this.type = type;
		this.roomID = roomID;
	}

}
