package se.iths.Skeppokaj.main;
import java.util.InputMismatchException;
import java.util.List;

import se.iths.Skeppokaj.db.DBStorage;
import se.iths.Skeppokaj.domain.Personnel;
public class Main{
	public static void main(String[] args){
		while(true){
			Storage storage = new DBStorage();
			String choice = "";
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
				System.out.println("Ta bort personal");	
				break;
			case "3":
				System.out.println("Ta bort personal");	
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

	
}
