package se.iths.Skeppokaj.main;
import java.util.List;

import se.iths.Skeppokaj.domain.Day;
import se.iths.Skeppokaj.domain.Machines;
import se.iths.Skeppokaj.domain.Personnel;
import se.iths.Skeppokaj.domain.Ships;

//import se.iths.domain.Movie;
//import se.iths.domain.Actor;

public interface Storage{
	public boolean addPersonnel(Personnel p);
	public boolean deletePersonnel(Personnel p);
	public boolean updateStatusPersonnel(Personnel p);
	public List<Personnel> getPersonnelByID(int persID);
	
	public boolean addMachine(Machines m);
	public boolean deleteMachine(Machines m);
	public boolean updateStatusMachine(Machines m);
	public List<Machines> getMachinesByID(int machineID);

	public boolean addShip(Ships s);
	public boolean deleteShip(Ships s);
	public List<Ships> getShipsByID(int shipID);
	public List<Ships> getAllShips();
	
	public List<Day> getCalendarForHarbourID(int harbourID);
	public int getHarbourIDForVol(String vol);

}
