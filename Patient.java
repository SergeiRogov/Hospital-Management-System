package hospital_management_system;

public class Patient {
	
	private String name;
	private String surname;
	private String illness;
	private String id;
	private String room;
	
	private static int patientCount = 0;

    public Patient(String name, String surname, String illness) {
        this.name = name;
        this.surname = surname;
        this.illness = illness;
        this.id = "" + patientCount;
        patientCount++;
    }
    
    protected void removePatient(String id) {
    	patientCount--;
    }

}
