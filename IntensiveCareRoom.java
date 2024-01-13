package hospital_management_system;

import java.util.ArrayList;

public class IntensiveCareRoom extends HospitalRoom {
	
	protected static ArrayList<IntensiveCareRoom> intensiveCareRooms = new ArrayList<>();

	public IntensiveCareRoom(double area, String id) {
		super(area, "Intensive Care", id);
		intensiveCareRooms.add(this);
	}

}
