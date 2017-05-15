package se.iths.Skeppokaj.main;
import java.util.List;

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
	public void addMachine(Machines m);
	public void deleteMachine(Machines m);
	public void updateMachine(Machines m);
	public boolean addShip(Ships s);
}
