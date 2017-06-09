package se.iths.Skeppokaj.domain;

import java.util.Date;

public class Report {
	
	private Date	date;
	private Date	time; 
	private String	harbour;
	private String 	shipName;
	private String	name;
	private int		priceWorker;
	private String	truck;
	private int 	priceTruck;
	private int		totalCost;
	
	
	public Report(Date date, Date time, String harbour, String shipName, String name, int priceWorker, String truck, int priceTruck, int totalCost) {
		this.date = date;
		this.time = time;
		this.harbour = harbour;
		this.shipName = shipName;
		this.name = name;
		this.priceWorker = priceWorker; 
		this.truck = truck;
		this.priceTruck = priceTruck;
		this.totalCost = totalCost;
	}
	
	
	public Date getDate() {
		return date;	
	}
	
	public void setDate(Date date) {
		this.date = date;	
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getHarbour() {
		return harbour;
	}
	
	public void setHarbour(String harbour) {
		this.harbour = harbour;
	}
	
	public String getShipName() {
		return shipName;
	}
	
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public int getPriceWorker() {
		return priceWorker;
	}
	
	public void setPriceWorker(int priceWorker) {
		this.priceWorker = priceWorker;
	}
	
	public String getTruck() {
		return truck;
	}
	
	public void setTruck(String truck) {
		this.truck = truck;
	}
	
	public int getPriceTruck() {
		return priceTruck;
	}
	
	public void setPriceTruck(int priceTruck) {
		this.priceTruck = priceTruck;
	}
	
	public int getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

}
