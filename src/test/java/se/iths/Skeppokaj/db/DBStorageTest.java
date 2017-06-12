package se.iths.Skeppokaj.db;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import se.iths.Skeppokaj.domain.Personnel;

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
}
