package se.iths.Skeppokaj.domain;

public class Machines {
	
	private int machineID;
	private String machineType;
	private String machineStatus;
	private int machineCost;
	
	
<<<<<<< HEAD
	public Machines(String machineType, String machineStatus) {
		super();
		this.machineType = machineType;
		this.machineStatus = machineStatus;
	}
	
	public Machines(int machineID, String machineType, String machineStatus) {
=======
	public Machines(int machineID, String machineType, String machineStatus, int machineCost) {
>>>>>>> 0f00ed4028a33130b7b338e65bdf74163bd8bc3e
		super();
		this.machineID = machineID;
		this.machineType = machineType;
		this.machineStatus = machineStatus;
		this.machineCost = machineCost;
	}
	
	
	
	public int getMachineID() {
		return machineID;
	}


	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}
		
	
	public String getMachineType() {
		return machineType;
	}


	public void setMachineType(String MachineType) {
		this.machineType = MachineType;
	}
	
		
	public String getMachineStatus() {
		return machineStatus;
	}


	public void setMachineStatus(String machineStatus) {
		this.machineStatus = machineStatus;
	}
	
<<<<<<< HEAD
		
=======
	
	public int getMachineCost() {
		return machineCost;
	}
	
	
	public void setMachineCost(int machineCost) {
		this.machineCost = machineCost;
	}
	
	
>>>>>>> 0f00ed4028a33130b7b338e65bdf74163bd8bc3e
	@Override
	public String toString(){
		return new StringBuilder(machineType)  //how do we want a machine to be printed? just type?
				.toString();
	}
}
