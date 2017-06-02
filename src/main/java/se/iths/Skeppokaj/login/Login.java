package se.iths.Skeppokaj.login;

import se.iths.Skeppokaj.main.TextUtil;

public class Login {

	public void loginMenu() {
		boolean loginFalse = true;
		while(loginFalse){
			boolean emptyUsername = true;
			String userName = "";
			while (emptyUsername) {
				userName = TextUtil.getReply("Användarnamn: ");
				emptyUsername = userName.isEmpty();
				if (emptyUsername) {
					System.out.println("Vänligen ange ett registrerat användarnamn!");
				}
			}
			String pwd = TextUtil.getReply("Lösenord: ");
			LoginManager lm = new LoginManager(userName, pwd);
			loginFalse = !lm.validate();
			if(loginFalse){
				System.out.println("Fel användarnamn eller lösenord, försök igen!");
			}

		}

	}

}
