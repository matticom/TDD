package customer;

import Euro.Euro;

public class MovieTest extends junit.framework.TestCase {

	public void testBasePrice() {
		Movie movie = new Movie();
		assertEquals(new Euro(2.0), movie.getCharge(1));
		assertEquals(new Euro(2.0), movie.getCharge(2));	
	}
	
	public void testPricePerDay() {
		Movie movie = new Movie();
		assertEquals(new Euro(3.75), movie.getCharge(3));
		assertEquals(new Euro(5.50), movie.getCharge(4));	
	}
}
