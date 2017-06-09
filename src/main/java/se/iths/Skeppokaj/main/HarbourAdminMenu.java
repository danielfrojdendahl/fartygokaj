package se.iths.Skeppokaj.main;

import java.util.ArrayList;
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
					List<Day> calendar = showSchema(ship);
					showMenu2(calendar);
				}
				break;
			case "2":
				System.out.println("Tillbaka till huvudmeny");
				return;
			}

		}

	}


	private List<Day> showSchema(Ships ship) {
		List<Day> calendar = new ArrayList<>();
		//System.out.println("Shows schema?");
		String vol = ship.getVolume();
		int harbourID = storage.getHarbourIDForVol(vol);
		if (harbourID != 0){
			calendar = storage.getCalendarForHarbourID(harbourID, ship);
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
		return calendar;

	}

	private void showMenu2(List<Day> calendar) {

		String choice = "";
		System.out.println("1. Välj dag");
		System.out.println("2. Tillbaka");
		while(!(choice.equals("1")||
				choice.equals("2"))){
			choice = TextUtil.getReply("Menyval: ");
		}
		switch(choice){
		case "1":
			Day day = getDay(calendar);
			showTimeSlots(day);
			showMenu3();
			break;
		case "2":
			System.out.println("Tillbaka till hamnadministration");
			break;
		}
	}



	private Day getDay(List<Day> calendar) {
		
		boolean notANumber = true;
		boolean notAFreeDay = true;
		int date = 0;

		while (notAFreeDay){
			while (notANumber){
				try{
					date = Integer.parseInt(TextUtil.getReply("Dag: "));
					notANumber = false;
				}catch(NumberFormatException ex){
					System.out.println("Ej giltigt värde, försök igen");
				}
			}
			notANumber = true;
			for(Day day:calendar){
				if(checkDayInCalendar(day, date)){
					notAFreeDay = false;
					return day;
				}else{
					System.out.println("Vald dag ej tillgänglig. Kontrollera kalenden!");
				}
			}
		}
		return null;
	}

	private boolean checkDayInCalendar(Day day, int date) {
		if(day.getDate()==date){
			if(day.getSlotOne()!=0 && day.getSlotTwo()!= 0 && day.getSlotThree()!=0){
				return false;
			}
		}
		return true;
	}



	private void showTimeSlots(Day day) {
		System.out.println("Slot1\tSlot2\tSlot3");
		System.out.println(day.getSlotOne()+"\t"+day.getSlotTwo()+"\t"+day.getSlotThree());
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