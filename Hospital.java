package hospital_management_system;

import java.util.ArrayList;

public class Hospital {
	
	private ArrayList<HospitalFloor> floors = new ArrayList<HospitalFloor>();
	
	public Hospital(ArrayList<HospitalFloor> floors) {
		this.floors = floors;
	}

}
