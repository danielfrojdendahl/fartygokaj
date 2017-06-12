package se.iths.Skeppokaj.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MachinesTest {

		Machines test;
		
	@Before	
	public void defineMachines() {
		test 	= new Machines(0, null, null, 0);
	}
	
	@Test
	public void machineCostTest() {
		assertEquals("check machineCost", 0, test.getMachineCost());
	}
	
	@Test
	public void machineIdTest() {
		test.setMachineID(1);
		assertEquals("Test if machineID is set properly", 1, test.getMachineID());
		
	}
	
	@Test
	public void machineTypeTest() {
		test.setMachineType("A001");
		assertEquals("Test if machineType is set properly", "A001", test.getMachineType());
	} 

	@Test
	public void machineStatusTest() {
		test.setMachineStatus("Ok");
		assertEquals("Test if machineStatus is set properly", "Ok", test.getMachineStatus());
	} 
}
