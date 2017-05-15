package se.iths.Skeppokaj.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipsTest {

	Ships test;
	
	@Before
	public void defineShips() {
		test = new Ships(1,"Explorer", "Maersk", "B007");
	}
	
	@Test
	public void getShipIDTest() {
		int result = test.getShipID();
		assertEquals("Test to see shipsID is null", 1, result);
	}
	
	@Test
	public void getShipNameTest() {
		assertEquals("check ship name", "Explorer", test.getShipName());
	}
	
	@Test
	public void setShipNameTest() {
		test.setShipName("Explorer");
		assertEquals("Check if ship name is set", "Explorer", test.getShipName());
	}
	
	@Test
	public void getCompanyTest() {
		assertEquals("check ship company", "Maersk", test.getCompany());
	}
	
	@Test
	public void setCompanyTest() {
		test.setCompany("Maersk");
		assertEquals("Check if ship company is set", "Maersk", test.getCompany());
	}
	
	@Test
	public void getVolumeTest() {
		assertEquals("check volume", "B007", test.getVolume());
	}
	
	@Test
	public void setVolumeTest() {
		test.setVolume("B008");
		assertEquals("check if volume is set", "B008", test.getVolume());
	}
}
