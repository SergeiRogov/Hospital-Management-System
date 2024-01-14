/**
 * @file Login_Passwords.java
 * @brief This file contains the Login_Passwords class.
 */
package hospital_management_system;

import java.util.HashMap;

/**
 * @class Login_Passwords
 * @brief Contains the HashMap with logins and passwords necessary for 
 * 		  authentication for the Hospital Management System application.
 */
public class Login_Passwords {
	
	// key-value pairs: login-password
	private HashMap<String, String> logininfo = new HashMap<String, String>();
	
	/**
	 * @method Login_Passwords
     * @brief Constructs a Login_Passwords instance with 3 pairs.
     */
	Login_Passwords(){
		logininfo.put("Admin1", "qwerty");
		logininfo.put("Admin2", "abcdefg");
		logininfo.put("Admin3", "123passcode");
	}
	
	/**
	 * @method getLoginInfo
     * @brief Getter method for logininfo.
     * @return login information.
     */
	protected HashMap<String, String> getLoginInfo(){
		return logininfo;
	}

}
