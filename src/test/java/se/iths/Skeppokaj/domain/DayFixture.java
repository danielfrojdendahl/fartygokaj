package se.iths.Skeppokaj.domain;

public class DayFixture {

	Day d = new Day(0, 0, 0, 0);
	private int weekDayNumber;
	
	public void setDate(int date) {
		d.setDate(date);
	}
	
	public int getDate() {
		return d.getDate();
	}
	
	public void setSlotOne(int slotOne) {
		d.setSlotOne(slotOne);
	}
	
	public int getSlotOne() {
		return d.getSlotOne();
	}
	
	public void setSlotTwo(int slotTwo) {
		d.setSlotTwo(slotTwo);
	}
	
	public int getSlotTwo() {
		return d.getSlotTwo();
	}
	
	public void setSlotThree(int slotThree) {
		d.setSlotThree(slotThree);
	}
	
	public int getSlotThree() {
		return d.getSlotThree();
	}
	
	public void setWeekDayNumber(int date) {
		this.weekDayNumber = date;
	}
	
	public int getWeekDayNumber() {
		return weekDayNumber;
	}
	
	public String getWeekDay() {
		this.d = new Day(weekDayNumber,0,0,0);
		return d.getDayOfWeek();
	}
}

