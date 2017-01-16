package customer;

public class CustomerTest extends junit.framework.TestCase {
	
	Customer customer;
	
	protected void setUp() {
		customer = new Customer();
	}
	
	public void testRentingNoMovies() {
		customer.rentMovie(0);
		assertEquals(0, customer.getTotalCharge(), 0.001);
	}
	
	public void testRentingOneMovie() {
		customer.rentMovie(1);
		assertTrue(customer.getTotalCharge() == 2);
	}
	
	public void testRentingTwoMovies() {
		customer.rentMovie(1);
		customer.rentMovie(2);
		assertEquals(4.0, customer.getTotalCharge(), 0.001);
	}
	
	public void testRentingThreeMovies() {
		customer.rentMovie(1);
		customer.rentMovie(2);
		customer.rentMovie(3);
		assertEquals(7.75, customer.getTotalCharge(), 0.001);
	}
	
	public void testRentingFourMovies() {
		customer.rentMovie(1);
		customer.rentMovie(2);
		customer.rentMovie(3);
		customer.rentMovie(4);
		assertEquals(13.25, customer.getTotalCharge(), 0.001);
	}
}
