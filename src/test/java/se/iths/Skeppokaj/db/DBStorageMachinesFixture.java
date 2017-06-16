package se.iths.Skeppokaj.db;

import java.util.List;

import se.iths.Skeppokaj.domain.Machines;
import se.iths.Skeppokaj.domain.Personnel;

public class DBStorageMachinesFixture {

	DBStorage storage = new DBStorage();

	String machineType;
	String machineStatus;
	int machineId;
	int machineCost;
	String newStatus;
	int soughtID;

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public String getMachineStatus() {
		return machineStatus;
	}

	public void setMachineStatus(String machineStatus) {
		this.machineStatus = machineStatus;
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineID) {
		this.machineId = machineID;
	}

	public int getMachineCost() {
		return machineCost;
	}

	public void setMachineCost(int machineCost) {
		this.machineCost = machineCost;
	}

	public String getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	public int getSoughtID() {
		return soughtID;
	}

	public void setSoughtID(int soughtID) {
		this.soughtID = soughtID;
	}

	public boolean addMachinesTest() {
		Machines m = new Machines(machineType, machineStatus);
		return storage.addMachine(m);
	}

	public boolean deleteMachinesTest(){
		Machines m = new Machines(machineId, machineType, machineStatus, machineCost);
		return storage.deleteMachine(m);
	}

	public boolean updateStatusMachineTest(){
		Machines m = new Machines(machineId, machineType, machineStatus, machineCost);
		m.setMachineStatus(newStatus);
		return storage.updateStatusMachine(m);
	}

	public List<Machines> getMachineByIDTest(){
		//Machines m = new Machines(machineId, machineType, machineStatus, machineCost);
		return storage.getMachinesByID(soughtID);
	}
}
