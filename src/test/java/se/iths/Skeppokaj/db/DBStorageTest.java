package se.iths.Skeppokaj.db;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import se.iths.Skeppokaj.domain.Machines;
import se.iths.Skeppokaj.domain.Personnel;
import se.iths.Skeppokaj.domain.Ships;

public class DBStorageTest {

	DBStorage storage;

	@Before
	public void defineDBStorage(){
		storage = new DBStorage();
	}

	@Test
	public void addPersonnelTest() {
		Personnel p = new Personnel("Apa", "Bepa", "A", "100%", "MF");
		assertTrue(storage.addPersonnel(p));
	}

	@Test
	public void addPersonnelVoidTest() {
		Personnel p = new Personnel("", "000", "G", "", "");
		assertFalse(storage.addPersonnel(p));
	}

	@Test
	public void deletePersonnelTest() {
		Personnel p = new Personnel(941, "Apa", "Bepa", "A", "100%", "MF");
		if(storage.addPersonnel(p)){
			assertTrue(storage.deletePersonnel(p));
		}else{
			fail("DeletePersonnel failed");
		}
	}

	@Ignore
	//@Test
	public void deletePersonnelVoidTest() {
		Personnel p = new Personnel("", "000", "G", "", "");
		assertFalse(storage.deletePersonnel(p));
	}

	@Test
	public void updateStatusPersonnelTest() {
		Personnel p = new Personnel(947,"Apa", "Bepa", "A", "100%", "MF");
		if(storage.addPersonnel(p)){
			p.setStatus("50%");
			assertTrue(storage.updateStatusPersonnel(p));
		}else{
			fail("UpdateStatusPersonnel failed");
		}
	}
	
	//Can't test this since there is no way to add a person to the db with a specific ID. Crap!
	@Ignore
	//@Test
	public void  getPersonnelByID() {
		Personnel p = new Personnel(941,"Apa", "Bepa", "A", "100%", "MF");
		List<Personnel> list;
		if(storage.addPersonnel(p)){
			list = storage.getPersonnelByID(941);
			assertTrue(list.contains(p));
		}else{
			fail("GetPersonnelByID failed");
		}
	}
	
	@Test
	public void addMachineTest() {
		Machines m = new Machines(10, "AA01", "Ok", 1000);
		assertTrue(storage.addMachine(m));
	}

	@Test
	public void addMachineVoidTests() {
		Machines m = new Machines(10, "000", "G", 1000);
		assertFalse(storage.addMachine(m));
	}

	@Test
	public void deleteMachineTest() {
		Machines m = new Machines(56, "AA01", "Ok", 1000);
		if(storage.addMachine(m)){
			assertTrue(storage.deleteMachine(m));
		}else{
			fail("DeleteMachine failed");
		}
}
	
	@Test
	public void updateStatusMachineTest() {
		Machines m = new Machines(40,"AA01", "Ok",1000);
		if(storage.addMachine(m)){
			m.setMachineStatus("Skadad");
			assertTrue(storage.updateStatusMachine(m));
		}else{
			fail("UpdateStatusMachinefailed");
		}
	}
	
	@Test
	public void  getMachineByID() {
		Machines m = new Machines(59,"AA01", "Reserv", 1000);
		List<Machines> list;
		if(storage.addMachine(m)){
			list = storage.getMachinesByID(59);
			//assertTrue(list.contains(m));
		}else{
			fail("GetMachineByID failed");
			}
		}
	@Ignore
	@Test
	public void addShipTest() {
		Ships s = new Ships(102, "Bepa", "DHL", "A005");
		assertTrue(storage.addShip(s));
	}
	@Ignore
	@Test
	public void deleteShipTest() {
		Ships s = new Ships(102, "Bepa", "DHL", "A005");
		if(storage.addShip(s)){
			assertTrue(storage.deleteShip(s));
		}else{
			fail("DeleteShip failed");
		}
	}
	
	public void  getShipByID() {
		Ships s = new Ships(19,"Diana", "Odio Tristique Limited", "A005");
		List<Ships> list;
		if(storage.addShip(s)){
			list = storage.getShipsByID(19);
			assertTrue(list.contains(s));
		}else{
			fail("GetShipByID failed");
		}
	}

	
}
