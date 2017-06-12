package se.iths.Skeppokaj.main;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class HelpUtilTest {
	
	HelpUtil helpUtil;
	
	@Before
	public void defineHelpUtil(){
		helpUtil = new HelpUtil();
	}

	@Test
	public void validMachineTypeTest() {
		String inputData = "A001";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String s = helpUtil.validMachineType();
		
		assertEquals(inputData, s);
	}

	@Test
	public void validVolumeTypeTest() {
		String inputData = "A005";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String s = helpUtil.validVolumeType();
		
		assertEquals(inputData, s);
	}
	
	@Test
	public void validPersonalStatusTest() {
		String inputData = "100%";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String s = helpUtil.validPersonalStatus();
		
		assertEquals(inputData, s);
	}
	
	@Test
	public void validSchemaTypeTest() {
		String inputData = "MF";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String s = helpUtil.validSchemaType();
		
		assertEquals(inputData, s);
	}
	
	@Test
	public void validNameTest() {
		String inputData = "Apa";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String s = helpUtil.validName();
		
		assertEquals(inputData, s);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void notValidNameTest() {
		String inputData = "9";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String s = helpUtil.validDriversLicense();
		
		assertEquals(inputData, s);
	}
	
	@Test
	public void validDriversLicenseTest() {
		String inputData = "A";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String s = helpUtil.validDriversLicense();
		
		assertEquals(inputData, s);
	}
	
	@Test
	public void validSurNameTest() {
		String inputData = "Bepa";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String s = helpUtil.validName();
		
		assertEquals(inputData, s);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void notValidSurNameTest() {
		String inputData = "9";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String s = helpUtil.validDriversLicense();
		
		assertEquals(inputData, s);
	}
}
