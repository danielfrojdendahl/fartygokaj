package se.iths.Skeppokaj.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DayTest {
	
	Day test;

	@Before
	public void defineDay() {
		test = new Day(0, 0, 0, 0);
	}
	@Test
	public void dateTest() {
		test.setDate(1);
		assertEquals("Test if Date is set properly", 1, test.getDate());
	}
	@Test
	public void slotOneTest() {
		test.setSlotOne(2);
		assertEquals("Test if slotOne is set properly", 2, test.getSlotOne());
	}
	@Test
	public void slotTwoTest() {
		test.setSlotTwo(3);
		assertEquals("Test if slotTwo is set properly", 3, test.getSlotTwo());
	}
	@Test
	public void slotThreeTest() {
		test.setSlotThree(4);
		assertEquals("Test if slotThree is set properly", 4, test.getSlotThree());
	}

}
