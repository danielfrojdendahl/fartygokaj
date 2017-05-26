package se.iths.Skeppokaj.login;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Mikaela
 *
 */
public class LoginManager {

	private LoginModel loginModel;  
	private static Map<String, String> logins = new HashMap<String, String>();

	static {
		logins.put("Sofia", "admin");
		logins.put("Daniel", "admin");
		logins.put("Samuel", "admin");
		logins.put("Mikaela", "admin");
		logins.put("Alex", "admin");
	}

	public LoginManager(String userName, String password) {
		loginModel = new LoginModel(); 
		loginModel.userName = userName;
		loginModel.password = password;
	}

	public boolean validate() {

		if (loginModel.userName.equals(null) || loginModel.userName.equals("")) {
			return false;
		}

		if (loginModel.password.equals(null) || loginModel.password.equals("")) {
			return false;
		}

		return validateCredencials();

	}

	private boolean validateCredencials() {

		if (logins.containsKey(loginModel.userName)) {
			String password = (String)logins.get(loginModel.userName);

			if (password.equals(loginModel.password)) {
				return true;
			}
			
		}
		return false;

	}
}
