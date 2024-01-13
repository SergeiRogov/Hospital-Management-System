package hospital_management_system;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<HospitalRoom> roomsFloor1 = new ArrayList<>();
		ArrayList<HospitalRoom> roomsFloor2 = new ArrayList<>();
		ArrayList<HospitalRoom> roomsFloor3 = new ArrayList<>();
		
		roomsFloor1.add(new OperatingRoom(30, "101"));
		roomsFloor1.add(new OperatingRoom(40, "102"));
		roomsFloor1.add(new OperatingRoom(40, "103"));
		roomsFloor1.add(new IntensiveCareRoom(40, "104"));
		roomsFloor1.add(new MedicalRoom(40, "105"));
		
		roomsFloor2.add(new IntensiveCareRoom(30, "201"));
		roomsFloor2.add(new IntensiveCareRoom(40, "202"));
		roomsFloor2.add(new IntensiveCareRoom(40, "203"));
		roomsFloor2.add(new MedicalRoom(40, "204"));
		
		roomsFloor3.add(new MedicalRoom(30, "301"));
		roomsFloor3.add(new MedicalRoom(40, "302"));
		roomsFloor3.add(new MedicalRoom(40, "303"));
		roomsFloor3.add(new IntensiveCareRoom(40, "304"));
		
		HospitalFloor hospitalFloor1 = new HospitalFloor(roomsFloor1);
		HospitalFloor hospitalFloor2 = new HospitalFloor(roomsFloor2);
		HospitalFloor hospitalFloor3 = new HospitalFloor(roomsFloor3);
		
		ArrayList<HospitalFloor> floors = new ArrayList<>();
	
		floors.add(hospitalFloor1);
		floors.add(hospitalFloor2);
		floors.add(hospitalFloor3);
		
		Hospital generalHospital = new Hospital(floors);

		Login_Passwords loginAndPasswords = new Login_Passwords();
		
		LoginPage loginPage = new LoginPage(loginAndPasswords.getLoginInfo());
	}

}
