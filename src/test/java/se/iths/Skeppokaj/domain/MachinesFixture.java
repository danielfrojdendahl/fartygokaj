package se.iths.Skeppokaj.domain;

public class MachinesFixture {
	
	Machines m = new Machines(0, null, null, 500);
	
	public void setMachineID(int machineID) {
		m.setMachineID(machineID);
	}
	
	public int getMachineID() {
		return m.getMachineID();
	}
	
	public void setMachineType(String machineType) {
		m.setMachineType(machineType);
	}
	
	public String getMachineType() {
		return m.getMachineType();
	}
	
	public void setMachineStatus(String machineStatus) {
		m.setMachineStatus(machineStatus);
	}
		
	public String getMachineStatus() {
		return m.getMachineStatus();
	}	
	
	public int getMachineCost() {
		return m.getMachineCost();
	}
}