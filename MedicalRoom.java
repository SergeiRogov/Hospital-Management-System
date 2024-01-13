package hospital_management_system;

import java.util.ArrayList;

public class MedicalRoom extends HospitalRoom {
	
	protected static ArrayList<MedicalRoom> medicalRooms = new ArrayList<>();

	public MedicalRoom(double area, String id) {
		super(area, "Medical", id);
		medicalRooms.add(this);
	}
	
}
