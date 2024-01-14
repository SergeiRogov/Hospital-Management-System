/**
 * @file Patient.java
 * @brief This file contains the Patient class.
 */
package hospital_management_system;

/**
 * @class Patient
 * @brief Represents a hospital patient.
 */
public class Patient {
	
	// Patient attributes
	private String name;
	private String surname;
	private String illness;
	private String id;
	private HospitalRoom room;
	
	// total number of patients ever created in a system
	private static int patientCount = 0;

	/**
	 * @method Patient
     * @brief Constructor of a patient.
     * @param name Name of a patient.
     * @param surname Surname of a patient.
     * @param illness Illness of a patient.
     */
    public Patient(String name, String surname, String illness) {
        this.name = name;
        this.surname = surname;
        this.illness = illness;
        this.id = patientCount + "";
        patientCount++;
    }
    
    /**
	 * @method Patient
     * @brief Overloaded constructor of a patient.
     * @param id ID of a patient.
     * @param name Name of a patient.
     * @param surname Surname of a patient.
     * @param illness Illness of a patient.
     * @param room Patient's room.
     */
    public Patient(String id, String name, String surname, String illness, HospitalRoom room) {
    	this.id = id;
    	this.name = name;
        this.surname = surname;
        this.illness = illness;
        this.room = room;
    }
    
    /**
	 * @method setRoom
     * @brief Setter method for a room.
     * @param room Patient's room.
     */
    public void setRoom(HospitalRoom room) {
    	this.room = room;
    }
    
    /**
	 * @method getID
     * @brief Getter method for ID.
     * @return Patient's ID.
     */
    public String getID() {
		return id;
	}
    
    /**
	 * @method getPatientCount
     * @brief Getter method for patientCount.
     * @return total number of patients ever created in a system.
     */
    public static int getPatientCount() {
		return patientCount;
	}
    
    /**
	 * @method setPatientCount
     * @brief Setter method for patientCount.
     * @param count Total number of patients ever created in a system.
     */
    public static void setPatientCount(int count) {
		patientCount = count;
	}
    
    /**
	 * @method stringToFile
     * @brief Converts a patient to string - to be stored in database file.
     * return String representation.
     */
    public String stringToFile() {
		return id + ";" + name + ";" + surname + ";" + illness + ";" + room.getRoomID();
	}
    
    /**
	 * @method toString
     * @brief Converts a patient to string.
     * return String representation.
     */
    public String toString() {
		return id + " [Name:" + name + " " + surname + "; Illness:" + illness + "]";
	}

}
