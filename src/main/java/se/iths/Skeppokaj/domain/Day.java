package se.iths.Skeppokaj.domain;

public class Day {

	private int date;
	private String dayOfWeek;
	private int slotOne;
	private int slotTwo;
	private int slotThree;
	
	public Day(int date, int slotOne, int slotTwo, int slotThree){
		super();
		this.date = date ;
		this.slotOne = slotOne;
		this.slotTwo = slotTwo;
		this.slotThree = slotThree;
		this.dayOfWeek = whatDay(date);
	}
	

	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public int getSlotOne() {
		return slotOne;
	}
	public void setSlotOne(int slotOne) {
		this.slotOne = slotOne;
	}
	public int getSlotTwo() {
		return slotTwo;
	}
	public void setSlotTwo(int slotTwo) {
		this.slotTwo = slotTwo;
	}
	public int getSlotThree() {
		return slotThree;
	}
	public void setSlotThree(int slotThree) {
		this.slotThree = slotThree;
	}
	
	private String whatDay(int date) {
		if(date<6){
			return "MF";
		}else if(date==6){
			return "L";
		}else{
			return "S";
		}
	}

	@Override
	public String toString() {
		String s="L";
		if(slotOne!=0&&slotTwo!=0&&slotThree!=0){
			s="";
		}
		return date + "," + s;
	}
	
}
