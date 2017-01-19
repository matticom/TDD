package customer;

import Euro.Euro;

public class CustomerTest extends junit.framework.TestCase {
	
	Customer customer;
	
	protected void setUp() {
		customer = new Customer();
	}
	
	public void testRentingNoMovies() {
		customer.rentMovie(0);
		assertEquals(new Euro(0), customer.getTotalCharge());
	}
	
	public void testRentingOneMovie() {
		customer.rentMovie(1);
		assertEquals(new Euro(2), customer.getTotalCharge());
	}
	
	public void testRentingTwoMovies() {
		customer.rentMovie(1);
		customer.rentMovie(2);
		assertEquals(new Euro(4.0), customer.getTotalCharge());
	}
	
	public void testRentingThreeMovies() {
		customer.rentMovie(1);
		customer.rentMovie(2);
		customer.rentMovie(3);
		assertEquals(new Euro(7.75), customer.getTotalCharge());
	}
	
	public void testRentingFourMovies() {
		customer.rentMovie(1);
		customer.rentMovie(2);
		customer.rentMovie(3);
		customer.rentMovie(4);
		assertEquals(new Euro(13.25), customer.getTotalCharge());
	}
}
