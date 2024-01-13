package hospital_management_system;

import java.util.ArrayList;

public class PatientList {
	
	private ArrayList<Patient> patients;
	
	public PatientList() {
        this.patients = new ArrayList<>();
    }

	public PatientList(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	
	public void addPatient(Patient patient) {
        patients.add(patient);
    }
	
	
	public ArrayList<Patient> getPatientList() {
        return patients;
    }
	
	public void removePatient(Patient patient) {
		patients.remove(patient);
	}

}
