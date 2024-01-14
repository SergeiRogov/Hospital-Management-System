/**
 * @file PatientList.java
 * @brief This file contains the PatientList class.
 */
package hospital_management_system;

import java.util.ArrayList;

/**
 * @class PatientList
 * @brief Represents the list of patients.
 */
public class PatientList {
	
	// list of patients
	private ArrayList<Patient> patients;
	
	/**
	 * @method PatientList
     * @brief Default constructor of a list of patients.
     */
	public PatientList() {
        this.patients = new ArrayList<>();
    }

	/**
	 * @method PatientList
     * @brief Constructs a list of patients (overloaded constructor).
     * @param patients List of hospital patients
     */
	public PatientList(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	
	/**
	 * @method addPatient
	 * @param patients List of hospital patients
     * @brief Adds a patient to a list.
     */
	public void addPatient(Patient patient) {
        patients.add(patient);
    }
	
	/**
	 * @method getPatientList
     * @brief Getter method for a list of patients.
     * @return List of patients.
     */
	public ArrayList<Patient> getPatientList() {
        return patients;
    }
	
	/**
	 * @method removePatient
     * @brief Removes given patient from a list.
     * @param patient Hospital patient.
     */
	public void removePatient(Patient patient) {
		patients.remove(patient);
	}

}
