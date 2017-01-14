package customer;

public class CustomerTest  extends junit.framework.TestCase{
	
	public void testRentingOneMovie() {
		Customer customer = new Customer();
		customer.rentMovie(1);
		assertTrue(customer.getTotalCharge() == 2);
	}
	
	public void testRentingTwoMovies() {
		Customer customer = new Customer();
		customer.rentMovie(1);
		customer.rentMovie(2);
		assertEquals(4, customer.getTotalCharge());
	}
	
}
