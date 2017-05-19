package se.iths.Skeppokaj.main;

import java.util.List;

import se.iths.Skeppokaj.db.DBStorage;
import se.iths.Skeppokaj.domain.Personnel;

public class PersonnelAdminMenu{
	public void start(){
		while(true){
			Storage storage = new DBStorage();
			String choice = "";
			System.out.println("");
			System.out.println("---PERSONALADMINISTRATION---");
			System.out.println("");
			System.out.println("1. Lägg till ny personal i databasen");
			System.out.println("2. Ta bort personal ur databasen");
			System.out.println("3. Uppdatera status för personal");
			System.out.println("4. Tillbaka till huvudmeny");
			while(!(choice.equals("1")||
					choice.equals("2")||
					choice.equals("3")||
					choice.equals("4"))){
				choice = TextUtil.getReply("Menyval: ");
			}
			switch(choice){
			case "1":
				System.out.println("Lägg till personal");
				String name = TextUtil.getReply("Förnamn: ");
				String surName = TextUtil.getReply("Efternamn: ");
				String driversLicence = TextUtil.getReply("Körkortstyp: ");
				String status = TextUtil.getReply("Status: ");
				String schemaType = TextUtil.getReply("Schematyp: ");

				Personnel p = new Personnel(name,surName,driversLicence,status,schemaType);
				if(storage.addPersonnel(p)){
					System.out.println("Adderat ok");
				}else{
					System.out.println("Addering gick fel, kolla .err");
				}
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
					if(storage.deletePersonnel(p2)){
						System.out.println("Borttagning ok");
					}else{
						System.out.println("Borttagning fungerade ej, kolla .err");
					}
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
					String status3 = TextUtil.getReply("Status: ");
					Personnel p3 = personnel3.get(0);
					p3.setStatus(status3);
					if(storage.updateStatusPersonnel(p3)){
						System.out.println("Status uppdaterad ok");
					}else{
						System.out.println("Kunde ej uppdatera status, kolla .err");
					}
				}
				break;
			case "4":
				System.out.println("Tillbaka till huvudmeny");
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