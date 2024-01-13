package hospital_management_system;

import java.util.ArrayList;

public class OperatingRoom extends HospitalRoom {
	
	protected static ArrayList<OperatingRoom> operatingRooms = new ArrayList<>();

	public OperatingRoom(double area, String id) {
		super(area, "Operating", id);
		operatingRooms.add(this);
	}

}
