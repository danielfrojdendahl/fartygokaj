package se.iths.Skeppokaj.domain;

public class MachinesFixture {
	
	private int 	machineID;
	private String 	machineType;
	private String 	machineStatus;
	
	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}
	
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	
	public void setMachineStatus(String machineStatus) {
		this.machineStatus = machineStatus;
	}
	
	public int getMachineID() {
		return machineID;
	}
	
}