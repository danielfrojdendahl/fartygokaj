package se.iths.Skeppokaj.db;

import java.util.List;

import se.iths.Skeppokaj.domain.Machines;
import se.iths.Skeppokaj.domain.Ships;

public class DBStorageShipsFixture {
	
	DBStorage storage = new DBStorage();
	private String shipName;
	private String shipCompany;
	private String shipVolume;
	private int shipId;
	private int soughtID;
	
	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipCompany() {
		return shipCompany;
	}

	public void setShipCompany(String shipCompany) {
		this.shipCompany = shipCompany;
	}

	public String getShipVolume() {
		return shipVolume;
	}

	public void setShipVolume(String shipVolume) {
		this.shipVolume = shipVolume;
	}

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public int getSoughtID() {
		return soughtID;
	}

	public void setSoughtID(int soughtID) {
		this.soughtID = soughtID;
	}

	public boolean addShipsTest() {
		Ships s = new Ships(shipName, shipCompany, shipVolume);
		return storage.addShip(s);
	}

	public boolean deleteShipsTest(){
		Ships s = new Ships(shipId, shipName, shipCompany, shipVolume);
		return storage.deleteShip(s);
	}

	public List<Ships> getShipsByIDTest(){
		return storage.getShipsByID(soughtID);
	}	
	
	public List<Ships> getAllShipsTest(){
		return storage.getAllShips();
	}	
}
