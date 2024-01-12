package hospital_management_system;

import java.util.HashMap;

public class Login_Passwords {
	
	private HashMap<String, String> logininfo = new HashMap<String, String>();
	
	Login_Passwords(){
		
		logininfo.put("q", "q");
		logininfo.put("Admin2", "abcdefg");
		logininfo.put("Admin3", "123passcode");
		
	}
	
	protected HashMap<String, String> getLoginInfo(){
		return logininfo;
	}

}
