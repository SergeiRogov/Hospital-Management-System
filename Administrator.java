/**
 * @file Administrator.java
 * @brief This file contains the Administrator class.
 */
package hospital_management_system;

/**
 * @class Administrator
 * @brief Represents administrator of the hospital.
 */
public class Administrator extends HospitalStaff {
	
	// (General, Assistant)
	private String status;

	/**
	 * @method Administrator
     * @brief Constructs an administrator.
     * @param name Name of administrator.
     * @param status Status of administrator (General, Assistant).
     */
	public Administrator(String name, String status) {
		super(name, 80000);
		this.status = status;
	}

	/**
	 * @method representAsStrings
     * @brief Makes a string representation of a class.
     * @return String representation.
     */
	@Override
	public String representAsString() {

		return "Administrator. Name: " + this.getName() + "; Salary:" + this.getSalary() + "$; Status: " + status;
	}

}
