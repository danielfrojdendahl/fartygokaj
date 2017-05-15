package se.iths.Skeppokaj.domain;

public class Ships {
	
	private int		shipID;
	private String	volume;
	private String 	shipName;
	private String 	company;
	
	public Ships(int shipID, String shipName, String company, String volume) {
		super();
		this.shipID		= shipID;
		this.shipName 	= shipName;
		this.company 	= company;
		this.volume 	= volume;
	}
	
	
	public Ships(String shipName, String company, String volume) {
		super();
		this.shipName 	= shipName;
		this.company 	= company;
		this.volume 	= volume;
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
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}
	
		
	public String getVolume() {
		return volume;
	}
	
		
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
		
	@Override
	public String toString(){
		return new StringBuilder(shipName)  //how do we want a ship to be printed? just name?
				.toString();
	}
}
