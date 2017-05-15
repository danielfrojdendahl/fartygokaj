package se.iths.Skeppokaj.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonnelTest {
	
	protected Personnel p;
	
	@Before
	public void before(){
		p = new Personnel(201,"Harry","Hare","A","Ledig","S");
	}

	@Test
	public void testGetFirstName(){
		assertEquals("Harry", p.getFirstName());
	}
	
	@Test
	public void testGetLastName(){
		assertEquals("Hare", p.getLastName());
	}
	
	@Test
	public void testGetStatus(){
		assertEquals("Ledig", p.getStatus());
	}
	
	@Test
	public void testGetPersId(){
		assertEquals(201, p.getPersId());
	}
	
	@Test
	public void testGetDriversLicence(){
		assertEquals("A", p.getDriversLicence());
	}

	@Test
	public void testGetSchemaType(){
		assertEquals("S", p.getSchemaType());
	}
	
	@Test
	public void testSetFirstName(){
		String name = "Kalle";
		p.setFirstName(name);
		assertEquals(name, p.getFirstName());
	}
	
	@Test
	public void testSetLastName(){
		String name = "Kula";
		p.setLastName(name);
		assertEquals(name, p.getLastName());
	}
	
	@Test
	public void testSetStatus(){
		String status = "100%";
		p.setStatus(status);
		assertEquals(status, p.getStatus());
	}
	
}
