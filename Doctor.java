/**
 * @file Doctor.java
 * @brief This file contains the Doctor class.
 */
package hospital_management_system;

import java.util.ArrayList;

/**
 * @class Doctor
 * @brief Represents doctors of the hospital.
 */
public class Doctor extends HospitalStaff {
	
	// List of patients
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	
	/**
	 * @method Doctor
     * @brief Constructs a doctor.
     * @param name Name of doctor.
     */
	public Doctor(String name) {
		super(name, 75000);
	}
	
	/**
	 * @method Doctor
     * @brief Constructs a doctor.
     * @param name Name of doctor.
     * @param patients List of doctor's patients.
     */
	public Doctor(String name, ArrayList<Patient> patients) {
		super(name, 75000);
		this.patients = patients;
	}
	
	/**
	 * @method Doctor
     * @brief Constructs a doctor.
     * @param name Name of doctor.
     * @param salary Doctor's salary.
     * @param patients List of doctor's patients.
     */
	public Doctor(String name, int salary, ArrayList<Patient> patients) {
		super(name);
		this.setSalary(salary);
		this.patients = patients;
	}
	
	/**
	 * @method addPatient
     * @brief Adds a patient to doctor's list.
     * @param patient Patient.
     */
	public void addPatient(Patient patient) {
		patients.add(patient);
	}
	
	/**
	 * @method removePatient
     * @brief Removes a patient from doctor's list.
     * @param patient Patient.
     */
	public void removePatient(Patient patient) {
		patients.remove(patient);
	}
	
	/**
	 * @method getPatientList
     * @brief Getter method for a PatientList.
     * @return List of patients.
     */
	public ArrayList<Patient> getPatientList(){
		return patients;
	}

	/**
	 * @method representAsStrings
     * @brief Makes a string representation of a class.
     * @return String representation.
     */
	@Override
	public String representAsString() {

		return "Doctor. Name: " + this.getName() + "; Salary: " + this.getSalary() + "$";
	}

}
