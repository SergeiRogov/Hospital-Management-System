/**
 * @file Main.java
 * @brief This file contains the Main class.
 */
package hospital_management_system;

/**
 * @class Main
 * @brief Contains the main function that kick-starts
 * 		  the Hospital Management System application.
 */
public class Main {

	/**
	 * @method main
	 * @brief The main method to start the Hospital Management System application.
	 */
	public static void main(String[] args) {
		
		// class that contains information on login info
		Login_Passwords loginAndPasswords = new Login_Passwords();
		
		// login page that authenticates the user
		new LoginPage(loginAndPasswords.getLoginInfo());
	}

}
