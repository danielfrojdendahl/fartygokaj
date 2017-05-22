package se.iths.Skeppokaj.main;

import java.util.List;

import se.iths.Skeppokaj.db.DBStorage;
import se.iths.Skeppokaj.domain.Machines;
import se.iths.Skeppokaj.domain.Personnel;

public class MachinesAdminMenu{
	public void start(){
		while(true){
			Storage storage = new DBStorage();
			String choice = "";
			System.out.println("");
			System.out.println("---MASKINADMINISTRATION---");
			System.out.println("");
			System.out.println("1. Lägg till ny maskin i databasen");
			System.out.println("2. Ta bort maskin ur databasen");
			System.out.println("3. Uppdatera status för maskin");
			System.out.println("4. Tillbaka till huvudmeny");
			while(!(choice.equals("1")||
					choice.equals("2")||
					choice.equals("3")||
					choice.equals("4"))){
				choice = TextUtil.getReply("Menyval: ");
			}
			switch(choice){
			case "1":
				System.out.print("Lägg till maskin");
				String machineType = TextUtil.getReply("Maskintyp: ");
				String machineStatus = TextUtil.getReply("Status: ");

				Machines m = new Machines(machineType, machineStatus);
				
				if(storage.addMachine(m)){
					System.out.println("Adderat ok");
				}else{
					System.out.println("Addering gick fel, kolla .err");
				}
				break;
			case "2":
				System.out.println("Ta bort maskin");
				int machID2 = getID();
				List<Machines> machines2 = storage.getMachinesByID(machID2);
				if (machines2.isEmpty()){
					System.out.println("Maskinen du söker finns ej i databasen.");
					//break or ask again?
				}else{
					//Should we list all machines and have user select one? Searching the db by id should only generate one choice.
					Machines m2 = machines2.get(0);
					if(storage.deleteMachine(m2)){
						System.out.println("Borttagning ok");
					}else{
						System.out.println("Borttagning fungerade ej, kolla .err");
					}
				}
				break;
			case "3":
				System.out.println("Uppdatera status för maskin");
				int machID3 = getID();
				List<Machines> machines3 = storage.getMachinesByID(machID3);
				if (machines3.isEmpty()){
					System.out.println("Maskinen du söker finns ej i databasen.");
					//break or ask again?
				}else{
					//Should we list all machines and have user select one? Searching the db by id should only generate one choice.
					Machines m3 = machines3.get(0);
					if(storage.updateStatusMachine(m3)){
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