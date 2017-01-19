package customer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Euro.Euro;

public class PriceTest {
	
	@Test
	public void testBasePrice() {
		assertEquals(new Euro(2.0), Price.NEWRELEASE.getCharge(1));
		assertEquals(new Euro(2.0), Price.NEWRELEASE.getCharge(2));	
	}
	
	@Test
	public void testPricePerDay() {
		assertEquals(new Euro(3.75), Price.NEWRELEASE.getCharge(3));
		assertEquals(new Euro(5.50), Price.NEWRELEASE.getCharge(4));	
	}
}
