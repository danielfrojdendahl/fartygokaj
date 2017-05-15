package se.iths.Skeppokaj.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MachinesTest {

		Machines test;
		
	@Before	
	public void defineMachines() {
		test 	= new Machines(0, null, null);
	}
	
	@Test
	public void MachineIdTest() {
		test.setMachineID(1);
		assertEquals("Test if machineID is set properly", 1, test.getMachineID());
		
	}
	
	@Test
	public void MachineTypeTest() {
		test.setMachineType("A001");
		assertEquals("Test if machineType is set properly", "A001", test.getMachineType());
	} 

	@Test
	public void MachineStatusTest() {
		test.setMachineStatus("OK");
		assertEquals("Test if machineStatus is set properly", "OK", test.getMachineStatus());
	} 
}
