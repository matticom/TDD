package customer;

public class MovieTest extends junit.framework.TestCase {

	public void testBasePrice() {
		Movie movie = new Movie();
		assertEquals(2.0, movie.getCharge(1), 0.001);
		assertEquals(2.0, movie.getCharge(2), 0.001);	
	}
	
	public void testPricePerDay() {
		Movie movie = new Movie();
		assertEquals(3.75, movie.getCharge(3), 0.001);
		assertEquals(5.50, movie.getCharge(4), 0.001);	
	}
}
