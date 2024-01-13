package hospital_management_system;

public class Patient {
	
	private String name;
	private String surname;
	private String illness;
	private String id;

	private HospitalRoom room;
	
	private static int patientCount = 0;

    public Patient(String name, String surname, String illness) {
        this.name = name;
        this.surname = surname;
        this.illness = illness;
        this.id = patientCount + "";
        patientCount++;
    }
    
    public void setRoom(HospitalRoom room) {
    	this.room = room;
    }
    
    public String toString() {
		return name + " " + surname + " " + illness + " " + id + " " + room.getRoomID() + " " + room.getType();
	}

}
