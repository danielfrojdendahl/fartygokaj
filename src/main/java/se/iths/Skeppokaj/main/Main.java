package se.iths.Skeppokaj.main;
import java.util.InputMismatchException;
import java.util.List;

import se.iths.Skeppokaj.db.DBStorage;
import se.iths.Skeppokaj.domain.Personnel;
import se.iths.Skeppokaj.login.LoginManager;
public class Main{
	public static void main(String[] args){
		
		//Login
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
		
		while(true){
			Storage storage = new DBStorage();
			String choice = "";
			drawShip();
			System.out.println("");
			System.out.println("---HUVUDMENY SKEPPOKAJ 1.0---");
			System.out.println("");
			System.out.println("1. Personaladministration");
			System.out.println("2. Maskinadministration");
			System.out.println("3. Hamnadministration");
			System.out.println("4. Rapport");
			System.out.println("5. Avsluta");
			while(!(choice.equals("1")||
					choice.equals("2")||
					choice.equals("3")||
					choice.equals("4")||
					choice.equals("5"))){
				choice = TextUtil.getReply("Menyval: ");
			}
			switch(choice){
			case "1":
				PersonnelAdminMenu pam = new PersonnelAdminMenu();
				pam.start();
				break;
			case "2":
				MachinesAdminMenu mam = new MachinesAdminMenu();
				mam.start();
				break;
			case "3":
				HarbourAdminMenu ham = new HarbourAdminMenu();
				ham.start();
				break;
			case "4":
				System.out.println("Ta bort personal");	
				break;
			case "5":
				System.out.println(" Bye ");
				return;
			}
		}
	}

	private static void drawShip() {
		System.out.println("        /\\/\\");
		System.out.println("");
		System.out.println("                        /\\/\\");
		System.out.println("        O  O  O");
		System.out.println("         O  O  O");
		System.out.println("                 O");
		System.out.println("                __|__");
		System.out.println("                || ||_____");
		System.out.println("                || ||    |");
		System.out.println("     --------------------------");
		System.out.println("      \\   O   O   O   O      /");
		System.out.println(" ~ ~ ~ ~ ~ ~ ~ ~  ~ ~ ~ ~ ~ ~ ~ ~");
		System.out.println("  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");		
	}


}
