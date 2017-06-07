package se.iths.Skeppokaj.main;

import java.util.List;

import se.iths.Skeppokaj.db.DBStorage;
import se.iths.Skeppokaj.domain.Day;
import se.iths.Skeppokaj.domain.Ships;

public class HarbourAdminMenu{

	private Storage storage = new DBStorage();

	public void start(){
		while(true){
			//Storage storage = new DBStorage();
			String choice = "";
			System.out.println("");
			System.out.println("---HAMNADMINISTRATION---");
			System.out.println("");
			System.out.println("1. Se fartyg i kö");
			System.out.println("2. Tillbaka till huvudmeny");
			while(!(choice.equals("1")||
					choice.equals("2"))){
				choice = TextUtil.getReply("Menyval: ");
			}
			switch(choice){
			case "1":
				System.out.println("Fartyg i kö");

				List<Ships> ships = storage.getAllShips();

				if (ships.isEmpty()){
					System.out.println("Fartygsdatabasen är tom. Det finns inga fartyg i kö. Ta en kaffepaus!");
					//break
				}else{
					//List all ships
					System.out.println("FartygsID     Namn      Företag");
					System.out.println("-------------------------------");
					for(Ships s:ships){
						System.out.println(s.getShipID()+"\t"+s.getShipName()+"\t"+s.getCompany());
					}
					//Pick one
					int shipID = getID();
					ships = storage.getShipsByID(shipID);

					if (ships.isEmpty()){
						System.out.println("Fartyget du söker finns ej i databasen.");

					}

					//Show schema for appropriate harbour for this ship
					Ships ship = ships.get(0);
					System.out.println("Skeppet "+ship.getShipName()+" är valt!");
					showSchema(ship);
					showMenu2();
				}
				break;
			case "2":
				System.out.println("Tillbaka till huvudmeny");
				return;
			}

		}

	}


	private void showSchema(Ships ship) {
		//System.out.println("Shows schema?");
		String vol = ship.getVolume();
		int harbourID = storage.getHarbourIDForVol(vol);
		if (harbourID != 0){
			List<Day> calendar = storage.getCalendarForHarbourID(harbourID, ship);
			System.out.println("Må	Ti	On	To	Fr	Lö	Sö");
			int i = 0;
			for(Day d:calendar){
				System.out.print(d.toString()+"	");
				i++;
				if(i % 7 == 0){
					System.out.println();
				}
			}
			System.out.println();
		}
		// TODO List schema for appropriate harbour
		/*get ship volume
		 * get appropriate harbour&no workers/machines from kajvol
		 * select harbour&date from kaj_calendar where a timeslot is free
		 * 
		 */

	}

	private void showMenu2() {

		String choice = "";
		System.out.println("1. Välj dag");
		System.out.println("2. Tillbaka");
		while(!(choice.equals("1")||
				choice.equals("2"))){
			choice = TextUtil.getReply("Menyval: ");
		}
		switch(choice){
		case "1":
			int i = getDay();
			//TODO check answer is a number and a number in free days
			//Show timeslots for day
			showTimeSlots(i);
			showMenu3();
			break;
		case "2":
			System.out.println("Tillbaka till hamnadministration");
			break;
		}
	}



	private int getDay() {
		boolean notANumber = true;
		boolean notAFreeDay = true;
		int day = 0;

		while (notAFreeDay){
			while (notANumber){
				try{
					day = Integer.parseInt(TextUtil.getReply("Dag: "));
					notANumber = false;
					if(checkDayInCalendar(day)){
						notAFreeDay = false;

					}else{
						System.out.println("Vald dag ej tillgänglig. Kontrollera kalenden!");
					}
				}catch(NumberFormatException ex){
					System.out.println("Ej giltigt värde, försök igen");
				}
			}
			notANumber = true;
		}
		return day;
	}

	private boolean checkDayInCalendar(int day) {
		//TODO Is day in the free calendar?
		return false;
	}



	private void showTimeSlots(int day) {
		//TODO List timeslots for chosen day

	}


	private void showMenu3() {
		String choice = "";
		System.out.println("1. Välj timeslot");
		System.out.println("2. Tillbaka");
		while(!(choice.equals("1")||
				choice.equals("2"))){
			choice = TextUtil.getReply("Menyval: ");
		}
		switch(choice){
		case "1":
			TextUtil.getReply("Timeslot: ");
			//TODO Try to book ship at timeslot
			//TODO OK?
			break;
		case "2":
			System.out.println("Tillbaka till kalender");
			break;
		}		
	}


	private static int getID() {
		boolean notANumber = true;
		int machID = 0;
		while (notANumber){
			try{
				machID = Integer.parseInt(TextUtil.getReply("Ange ID: "));
				notANumber = false;
			}catch(NumberFormatException ex){
				System.out.println("Inget nummer, försök igen");
			}
		}		
		return machID;
	}
}