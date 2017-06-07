package se.iths.Skeppokaj.db;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import se.iths.Skeppokaj.domain.Day;
import se.iths.Skeppokaj.domain.Machines;
import se.iths.Skeppokaj.domain.Personnel;
import se.iths.Skeppokaj.domain.Ships;
//import org.iths.domain.Movie;
//import org.iths.domain.Actor;
import se.iths.Skeppokaj.main.Storage;

/**
 * This class should contain all methods that communicates with the database.
 * E.g add/delete/update personnel from database.
 * @author Kråkan
 *
 */
public class DBStorage implements Storage{

	//Change to your db name and path!
	private static final String PATH = "jdbc:sqlite:skeppokaj.db";
	private static Connection con;

	static{ // Will run once, when this class is loaded. Connection to db is initiated.
		try{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(PATH);
		}catch(ClassNotFoundException|SQLException e){
			System.err.println("Exception getting connection: " + e.getMessage());
		}
	}

	//Do we have a connection?
	public boolean hasConnection(){
		return con != null;
	}

	//Method to add persons to the personnel db
	public boolean addPersonnel(Personnel p){

		if(hasConnection()){
			//Preparation of data to put in db
			Statement stm = null;
			String firstName = p.getFirstName();
			String lastName = p.getLastName();
			//int persId = p.getPersId();
			String driversLicence = p.getDriversLicence();
			String status = p.getStatus();
			String schemaType = p.getSchemaType();

			try{
				//SQL-statement to insert data in db
				String sql = "INSERT INTO personal(Firstname,Lastname,License,Status,Schema) VALUES('" + firstName +
						"','" + lastName + "','"+ driversLicence + "','" + status + "','" + schemaType + "')";
				stm = con.createStatement();
				stm.executeUpdate(sql);
				String sqlID = "SELECT max(p_id) FROM personal";
				ResultSet rs = con.createStatement().executeQuery(sqlID);
				System.out.println(firstName + " " + lastName +" " + rs.getInt(1) + " adderad till databasen.");
				return true;

			}catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kan inte lägga till person " + firstName + " " + lastName +". Vänligen kontrollera insert statement!");
			}
			//Alerts.display("Wrong" ,"date format incorrect");

		}
		return false;
	}

	public boolean deletePersonnel(Personnel p){
		if(hasConnection()){
			Statement stm = null;
			int persID = p.getPersId();

			try{
				String sql = "DELETE FROM personal WHERE p_id =" + persID;
				stm = con.createStatement();
				stm.executeUpdate(sql);
				System.out.println("Person borttagen : " + p.getFirstName() + " " + p.getLastName() + " PersId: " + p.getPersId());
				return true;

			}catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kunde inte ta bort person, " + p.getFirstName() + " " + p.getLastName() + " PersId: " + p.getPersId());
			}

		}
		return false;
	}

	public boolean updateStatusPersonnel(Personnel p) {
		if(hasConnection()){
			Statement stm = null;
			int persID = p.getPersId(); 
			String status = p.getStatus();

			try{
				String sql = "UPDATE personal SET Status='"+status+"' WHERE p_id =" + persID;
				stm = con.createStatement();
				stm.executeUpdate(sql);
				System.out.println("Person "+ p.getFirstName()+" "+p.getLastName()+ p.getPersId() +  ", status uppdaterad.");
				return true;

			}catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kunde inte uppdatera person, "+p.getFirstName()+" "+p.getLastName() +  "PersId: " + p.getPersId());
			}
		}
		return false;
	}

	public List<Personnel> getPersonnelByID(int persID){
		List<Personnel> personnel = new ArrayList<>();
		try{
			//String sql = "SELECT * FROM personal WHERE p_id=" + persID;
			String sql = "SELECT p_id, Firstname, Lastname, License, Status, Schema, Hourly_salary FROM personal, employee_salary WHERE License=D_id AND p_id=" + persID;


			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next()){
				Personnel p  = new Personnel(rs.getInt("p_id"),rs.getString("Firstname"),rs.getString("Lastname"),rs.getString("License"),rs.getString("Status"),rs.getString("Schema"));
				personnel.add(p);
			}
		}catch(SQLException e){
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}      
		return personnel;
	}


	public boolean addMachine(Machines m) {
		if(hasConnection()){
			Statement stm = null;
			String machineType = m.getMachineType();
			String machineStatus = m.getMachineStatus();
			try{
				String sql = "INSERT INTO trucks(T_type,T_status) VALUES('" + machineType + "','" + machineStatus + "')";
				stm = con.createStatement();
				stm.executeUpdate(sql);
				String sqlID = "SELECT max(t_id) FROM trucks";
				ResultSet rs = con.createStatement().executeQuery(sqlID);
				System.out.println("Maskin ID: "+ rs.getInt(1) + " " + machineType + " är nu adderad till databasen.");
				return true;
			}

			catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kan inte lägga till maskin" + " " + machineType +". Vänligen kontrollera insert statement");
			}
		}
		return false;

	}

	public boolean deleteMachine(Machines m) {
		if(hasConnection()){
			Statement stm = null;
			int machineID = m.getMachineID();

			try{
				String sql = "DELETE FROM trucks WHERE T_id =" + machineID;
				stm = con.createStatement();
				stm.executeUpdate(sql);
				System.out.println("Maskin borttagen: " + machineID);
				return true;

			}catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kunde inte ta bort maskinen, "+machineID+" "+m.getMachineStatus());
			}

		}
		return false;
	}

	public boolean updateStatusMachine(Machines m) {
		if (hasConnection()){
			Statement stm = null;
			int truckid = m.getMachineID();
			String truckstatus = m.getMachineStatus();

			try{
				String sql = "UPDATE trucks SET T_status='" +truckstatus+ "' WHERE T_id =" + truckid;
				stm = con.createStatement();
				stm.executeUpdate(sql);
				System.out.println("Trucken " +truckid+ " Med Status "+truckstatus+", uppdaterad");
				return true;

			}catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kunde inte uppdatera truck, " +truckid+ " " +truckstatus);
			}
		}
		return false;
	}	

	public List<Machines> getMachinesByID(int machineID){
		List<Machines> machine = new ArrayList<>();
		try{
			String sql = "SELECT T_id, T_type, T_status, T_cost FROM trucks,machine_cost WHERE T_type=mc_type AND T_id=" + machineID;

			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next()){
				Machines m  = new Machines(rs.getInt("T_id"),rs.getString("T_type"),rs.getString("T_status"),rs.getInt("T_cost"));
				machine.add(m);
			}
		}catch(SQLException e){
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}      
		return machine;
	}

	public boolean addShip(Ships s) {
		if (hasConnection()) {
			Statement stm = null;
			String shipName = s.getShipName();
			String shipCompany = s.getCompany();
			String shipVolume = s.getVolume();

			try{
				String sql = "INSERT INTO ships(S_id, S_name, S_company, S_volume) VALUES(" + shipName + "','" + shipCompany + "','" + shipVolume + "')";
				stm = con.createStatement();
				stm.executeUpdate(sql);
				System.out.println(shipName + "är nu adderad till databasen.");
				return true;
			}

			catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kan inte lägga till fartyg" + " " + shipVolume +". Vänligen kontrollera insert statement");
			}
		}
		return false;
	}

	public boolean deleteShip(Ships s) {
		if(hasConnection()){
			Statement stm = null;
			int shipID = s.getShipID();


			try{
				String sql = "DELETE FROM ships WHERE S_id =" + shipID;
				stm = con.createStatement();
				stm.executeUpdate(sql);
				System.out.println("Fartyg borttagen");
				return true;

			}catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kunde inte ta bort fartyget, "+s.getShipName()+" "+s.getCompany()+" "+s.getVolume());
			}

		}
		return false;
	}

	public List<Ships> getShipsByID(int shipID){
		List<Ships> ships = new ArrayList<>();
		try{
			String sql = "SELECT * FROM ships WHERE S_id=" + shipID;

			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next()){
				Ships s  = new Ships(rs.getInt("S_id"),rs.getString("S_name"),rs.getString("S_company"),rs.getString("S_volume"));
				ships.add(s);
			}
		}catch(SQLException e){
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}      
		return ships;
	}

	@Override
	public List<Ships> getAllShips() {
		List<Ships> ships = new ArrayList<>();
		try{
			String sql = "SELECT * FROM ships";

			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next()){
				Ships s  = new Ships(rs.getInt("S_id"),rs.getString("S_name"),rs.getString("S_company"),rs.getString("S_volume"));
				ships.add(s);
			}
		}catch(SQLException e){
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}      
		return ships;
	}

	public List<Day> getCalendarForHarbourID(int harbourID, Ships ship){
		List<Day> calendar = new ArrayList<>();
		try{
			String sql = "SELECT  kaj_date, kaj_slot1, kaj_slot2, kaj_slot3 FROM kajcalendar WHERE kaj_id=" + harbourID;
			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next()){
				Day day = new Day(rs.getInt("kaj_date"),rs.getInt("kaj_slot1"),rs.getInt("kaj_slot2"),rs.getInt("kaj_slot3"));
				int slotOne = day.getSlotOne();
				int slotTwo = day.getSlotTwo();
				int slotThree = day.getSlotThree();


				//Time to populate calendar. If timeslot is empty and there is not enough workers timeslot=-1, else just add day.
				if(slotOne==0&&getAvailableWorkers(day, ship, 1)==null){
					day.setSlotOne(-1);
					calendar.add(day);
				} else if(slotTwo==0&&getAvailableWorkers(day, ship, 2)==null){
					day.setSlotTwo(-1);
					calendar.add(day);
				} else if(slotThree==0&&getAvailableWorkers(day, ship, 3)==null){
					day.setSlotThree(-1);
					calendar.add(day);
				} else {
					calendar.add(day);
				}
			}
		}catch(SQLException e){
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return calendar;
	}

	public int getHarbourIDForVol(String vol){
		int harbourID = 0;
		try{
			String sql = "SELECT kaj_id FROM kajvol WHERE kaj_volume='" +vol+ "'";
			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next()){
				harbourID = rs.getInt("kaj_id");
			}
		}catch(SQLException e){
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return harbourID;
	}

	/**
	 * Method to list a group of available workers for specified day, slot and ship
	 * 
	 * @param day The day we want a work group for
	 * @param ship The ship that we want a work group for
	 * @param slot The specific timeslot we want the group to work in
	 * @return A list of workers, returns null if the list is shorter than required.
	 */
	public List<Personnel> getAvailableWorkers(Day day, Ships ship, int slotNr){
		//System.out.println("slotnr: "+slotNr);
		List<Personnel> availableWorkers = new ArrayList<>();
		int numberOfWorkers = Integer.parseInt(ship.getVolume().substring(3));
		//System.out.println("antal begära arbetare): "+numberOfWorkers);
		String dayOfWeek = day.getDayOfWeek();
		//System.out.println("veckodag: "+dayOfWeek+" datum: "+day.getDate());
		List<Integer> bookedWorkersForDay = getBookedWorkersForDay(day, slotNr);
		//System.out.println("Bokade arbetare för dag: "+bookedWorkersForDay.size());
		String license = ship.getVolume().substring(0, 2);

		if(license.substring(1).equals("0")){
			license = license.substring(0, 1);
		}

		String sql = "SELECT p_id, Firstname, Lastname, License, Status, Schema FROM personal WHERE Schema='" +dayOfWeek+ "' AND License='" +license+ "' AND Status='100%'";
		ResultSet rs;
		try {
			rs = con.createStatement().executeQuery(sql);

			//System.out.println("rs storlek: "+rs.next());
			while(rs.next()){
				//System.out.println("p_id: "+rs.getInt("p_id"));
				//System.out.println("finns i bookedworkers: "+bookedWorkersForDay.contains(rs.getInt("p_id")));
				if(!bookedWorkersForDay.contains(rs.getInt("p_id"))){
					Personnel p  = new Personnel(rs.getInt("p_id"),rs.getString("Firstname"),rs.getString("Lastname"),rs.getString("License"),rs.getString("Status"),rs.getString("Schema"));
					availableWorkers.add(p);
				}
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

		//System.out.println("tillgängliga arbetare st: "+availableWorkers.size());
		if(availableWorkers.size()>= numberOfWorkers){
			return availableWorkers.subList(0, numberOfWorkers);
		}

		return null;
	}

	/**
	 * Helpmethod to collect all booked workers for all other slots a specific day.
	 * 
	 * @param day The specific day
	 * @param slot The slot we want to book
	 * @return List of booked workers for specified day
	 */
	private List<Integer> getBookedWorkersForDay(Day day, int slotNr){

		int workGroupIdOther1 = 0;
		int workGroupIdOther2 = 0;
		List<Integer> bookedPersonnel = new ArrayList<>();

		//Get id of workgroups in the other slots
		switch(slotNr){

		case 1: workGroupIdOther1 = day.getSlotTwo();
		workGroupIdOther2 = day.getSlotThree();
		break;
		case 2: workGroupIdOther1 = day.getSlotOne();
		workGroupIdOther2 = day.getSlotThree();
		break;
		case 3: workGroupIdOther1 = day.getSlotOne();
		workGroupIdOther2 = day.getSlotTwo();
		default: break;
		}	

		try{
			String sql = "SELECT pers_id FROM booked WHERE booked_id=" +workGroupIdOther1+ " OR booked_id=" +workGroupIdOther2;
			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next()){
				bookedPersonnel.add(rs.getInt("pers_id"));
			}
		}catch(SQLException e){
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

		return bookedPersonnel;
	}


}

