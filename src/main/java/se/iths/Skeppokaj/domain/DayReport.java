package se.iths.Skeppokaj.domain;

import java.util.Date;

public class DayReport extends Report {
	
	public DayReport(Date date, Date time, String harbour, String shipName, String name, int priceWorker, String truck, int priceTruck, int totalCost) {
		super(date, time, harbour, shipName, name, priceWorker, truck, priceTruck, totalCost);
	}
	

}
