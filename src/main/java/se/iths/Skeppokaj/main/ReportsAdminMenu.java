package se.iths.Skeppokaj.main;

import se.iths.Skeppokaj.db.DBStorage;

public class ReportsAdminMenu {
	public void start(){
		while(true){
			Storage storage = new DBStorage();
			String choice = "";
			System.out.println("");
			System.out.println("---RAPPORTERING---");
			System.out.println("");
			System.out.println("1. Hämta dagsrapport");
			System.out.println("2. Hämta veckorapport");
			System.out.println("3. Tillbaka till huvudmeny");
			while(!(choice.equals("1")||
					choice.equals("2")||
					choice.equals("3"))){
				choice = TextUtil.getReply("Menyval: ");
			}
			switch(choice){
			case "1":
				System.out.println("Hämta dagsrapporter");
				String date = TextUtil.getReply("Dag: ");
				
				
				break;
			case "2":
				System.out.println("Hämta veckorapporter");
				String startDateOfWeek = TextUtil.getReply("Första dagen i de kommande 7 dagarna: ");
				break;
			case "3":
				return;
			}
		}
	}	
}
