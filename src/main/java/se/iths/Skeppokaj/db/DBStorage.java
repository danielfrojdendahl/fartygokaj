package se.iths.Skeppokaj.db;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

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
				System.out.println(firstName + " " + lastName +" adderad till databasen.");
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
				System.out.println("Person borttagen");
				return true;

			}catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kunde inte ta bort person, "+p.getFirstName()+" "+p.getLastName());
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
				System.out.println("Person "+ p.getFirstName()+" "+p.getLastName()+", status uppdaterad.");
				return true;

			}catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kunde inte uppdatera person, "+p.getFirstName()+" "+p.getLastName());
			}
		}
		return false;
	}

	public List<Personnel> getPersonnelByID(int persID){
		List<Personnel> personnel = new ArrayList<>();
		try{
			String sql = "SELECT * FROM personal WHERE p_id=" + persID;

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
				String sql = "INSERT INTO trucks(T_type,T_status,T_cost) VALUES(" + machineType + "','" + machineStatus +"')";
				stm = con.createStatement();
				stm.executeUpdate(sql);
				System.out.println(machineType + "är nu adderad till databasen.");
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
				String sql = "DELETE FROM trucks WHERE m_id =" + machineID;
				stm = con.createStatement();
				stm.executeUpdate(sql);
				System.out.println("Maskin borttagen");
				return true;

			}catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kunde inte ta bort maskinen, "+m.getMachineType()+" "+m.getMachineStatus());
			}

		}
		return false;
	}

	public boolean updateMachine(Machines m) {
		if (hasConnection()){
			Statement stm = null;
			int truckid = m.getMachineID();
			String truckstatus = m.getMachineStatus();

			try{
				String sql = "UPDATE trucks SET T_status='" +truckstatus+ "' WHERE T_id =" + truckid;
				stm = con.createStatement();
				stm.executeUpdate(sql);
				System.out.println("Trucken " +truckid+ " "+truckstatus+", Status uppdaterad");
				return true;

			}catch(SQLException e){
				System.out.println(e.getMessage());
				System.out.println("Kunde inte uppdatera truck, " +truckid+ " " +truckstatus);
			}
		}
		return false;
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
}

