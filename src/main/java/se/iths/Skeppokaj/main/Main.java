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
			System.out.println("---PERSONAL---");
			System.out.println("");
			System.out.println("1. Lägg till ny personal i databasen");
			System.out.println("2. Ta bort personal ur databasen");
			System.out.println("3. Uppdatera status för personal");
			System.out.println("4. Avsluta");
			while(!(choice.equals("1")||
					choice.equals("2")||
					choice.equals("3")||
					choice.equals("4"))){
				choice = TextUtil.getReply("Menyval: ");
			}
			switch(choice){
			case "1":
				System.out.print("Lägg till personal");
				String name = TextUtil.getReply("Förnamn: ");
				String surName = TextUtil.getReply("Efternamn: ");
				String driversLicence = TextUtil.getReply("Körkortstyp: ");
				String status = TextUtil.getReply("Status: ");
				String schemaType = TextUtil.getReply("Schematyp: ");

				Personnel p = new Personnel(name,surName,driversLicence,status,schemaType);
				storage.addPersonnel(p);
				break;
			case "2":
				System.out.println("Ta bort personal");
				int persID2 = getID();
				List<Personnel> personnel2 = storage.getPersonnelByID(persID2);
				if (personnel2.isEmpty()){
					System.out.println("Personen du söker finns ej i databasen.");
					//break or ask again?
				}else{
					//Should we list all personnel and have user select one? Searching the db by id should only generate one choice.
					Personnel p2 = personnel2.get(0);
					storage.deletePersonnel(p2);
				}
				break;
			case "3":
				System.out.println("Uppdatera status för personal");
				int persID3 = getID();
				List<Personnel> personnel3 = storage.getPersonnelByID(persID3);
				if (personnel3.isEmpty()){
					System.out.println("Personen du söker finns ej i databasen.");
					//break or ask again?
				}else{
					//Should we list all personnel and have user select one? Searching the db by id should only generate one choice.
					Personnel p3 = personnel3.get(0);
					storage.updateStatusPersonnel(p3);
				}
				break;
			case "4":
				System.out.println(" Bye ");
				return;
			}
		}
	}

	private static int getID() {
		boolean notANumber = true;
		int persID = 0;
		while (notANumber){
			try{
				persID = Integer.parseInt(TextUtil.getReply("Ange ID: "));
				notANumber = false;
			}catch(NumberFormatException ex){
				System.out.println("Inget nummer, försök igen");
			}
		}		
		return persID;
	}
}
