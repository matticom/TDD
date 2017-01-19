package customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Euro.Euro;

public class RegularPriceTest {

	private RegularPrice price;

	@Before
	public void setUp() {
		price = new RegularPrice();
	}

	@Test
	public void testChargingOneDayRental() {
		assertEquals(new Euro(1.50), price.getCharge(1));
	}

	@Test
	public void testChargingThreeDaysRental() {
		assertEquals(new Euro(1.50), price.getCharge(3));
	}

	@Test
	public void testChargingFourDaysRental() {
		assertEquals(new Euro(3.00), price.getCharge(4));
	}

	@Test
	public void testChargingFiveDaysRental() {
		assertEquals(new Euro(4.50), price.getCharge(5));
	}
}