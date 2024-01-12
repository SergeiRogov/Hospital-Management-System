package hospital_management_system;

public class Main {

	public static void main(String[] args) {

		Login_Passwords loginAndPasswords = new Login_Passwords();
		
		LoginPage loginPage = new LoginPage(loginAndPasswords.getLoginInfo());
	}

}
