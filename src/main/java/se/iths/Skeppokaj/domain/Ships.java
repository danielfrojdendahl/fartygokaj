package se.iths.Skeppokaj.domain;

public class Ships {
	
	private int		shipID;
	private String	shipVolume;
	private String 	shipName;
	private String 	shipCompany;
	
	public Ships(int shipID, String shipName, String shipCompany, String shipVolume) {
		super();
		this.shipID			= shipID;
		this.shipName 		= shipName;
		this.shipCompany 	= shipCompany;
		this.shipVolume 	= shipVolume;
	}
	
	
	public Ships(String shipName, String shipCompany, String shipVolume) {
		super();
		this.shipName 		= shipName;
		this.shipCompany 	= shipCompany;
		this.shipVolume 	= shipVolume;
	}
		
	
	public int getShipID() {
		return shipID;
	}
	
	
	public void setShipID(int shipID) {
		this.shipID = shipID;
	}
	
		
	public String getShipName() {
		return shipName;
	}


	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
		
	public String getCompany() {
		return shipCompany;
	}


	public void setCompany(String shipCompany) {
		this.shipCompany = shipCompany;
	}
	
		
	public String getVolume() {
		return shipVolume;
	}
	
		
	public void setVolume(String shipVolume) {
		this.shipVolume = shipVolume;
	}
	
		
	@Override
	public String toString(){
		return new StringBuilder(shipName)  //how do we want a ship to be printed? just name?
				.toString();
	}
}
