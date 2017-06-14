package se.iths.Skeppokaj.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShipsFixture {

	Ships s = new Ships(0, null, null, null);
	
	public void setShipID(int shipID) {
		s.setShipID(shipID);
	}
	
	public int getShipID() {
		return s.getShipID();
	}
	
	public void setShipName(String shipName) {
		s.setShipName(shipName);
	}
	
	public String getShipName() {
		return s.getShipName();
	}
	
	public void setCompany(String shipCompany) {
		s.setCompany(shipCompany);
	}
	
	public String getCompany() {
		return s.getCompany();
	}
	
	public void setVolume(String shipVolume) {
		s.setVolume(shipVolume);
	}
	
	public String getVolume() {
		return s.getVolume();
	}

}
