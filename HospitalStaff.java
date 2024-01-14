/**
 * @file HospitalStaff.java
 * @brief This file contains the HospitalStaff class.
 */
package hospital_management_system;

/**
 * @class HospitalStaff
 * @brief Represents the staff workers the hospital.
 */
public abstract class HospitalStaff {
	
	private String name;
	private int salary;
	
	/**
	 * @method HospitalStaff
     * @brief Constructor of a class HospitalStaff.
     * @return Salary of a worker.
     */
	public HospitalStaff(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	/**
	 * @method HospitalStaff
     * @brief Constructor of a class HospitalStaff.
     * @return Salary of a worker.
     */
	public HospitalStaff(String name) {
		this.name = name;
	}
	
	/**
	 * @method getName
     * @brief Getter method for name.
     * @return Name of a worker.
     */
	public String getName(){
		return this.name;
	}
	
	/**
	 * @method getSalary
     * @brief Getter method for salary.
     * @return Salary of a worker.
     */
	public int getSalary(){
		return this.salary;
	}
	
	/**
	 * @method getSalary
     * @brief Getter method for salary.
     * @return Salary of a worker.
     */
	public void setSalary(int salary){
		this.salary = salary;
	}
	
	/**
	 * @method representAsString
     * @brief Makes a string representation of a class.
     * @return String representation.
     */
	public abstract String representAsString();

}
