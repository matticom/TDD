package customer;

import org.junit.Before;
import org.junit.Test;

import Euro.Euro;

public class CustomerTest extends junit.framework.TestCase {

	Customer customer;

	private Movie buffalo66, jungleBook, pulpFiction;

	@Before
	public void setUp() {
		customer = new Customer();

		buffalo66 = new Movie("Buffalo 66", Price.NEWRELEASE);
		jungleBook = new Movie("Das Dschungelbuch", Price.REGULAR);
		pulpFiction = new Movie("Pulp Fiction", Price.NEWRELEASE);
	}

	@Test
	public void testPrintingStatement() {
		customer.rentMovie(buffalo66, 4);
		customer.rentMovie(jungleBook, 1);
		customer.rentMovie(pulpFiction, 4);
		buffalo66.setPrice(Price.REGULAR);
		String actual = customer.printStatement();
		String expected = "\tBuffalo 66\t3,00\n" + "\tDas Dschungelbuch\t1,50\n" + "\tPulp Fiction\t5,50\n" + "Gesamt: 10,00\n";
		assertEquals(expected, actual);
	}

	@Test
	public void testRentingNoMovies() {
		customer.rentMovie(pulpFiction, 0);
		assertEquals(new Euro(0), customer.getTotalCharge());
	}

	@Test
	public void testRentingOneMovie() {
		customer.rentMovie(pulpFiction, 1);
		assertEquals(new Euro(2), customer.getTotalCharge());
	}

	@Test
	public void testRentingTwoMovies() {
		customer.rentMovie(pulpFiction, 1);
		customer.rentMovie(pulpFiction, 2);
		assertEquals(new Euro(4.0), customer.getTotalCharge());
	}

	@Test
	public void testRentingThreeMovies() {
		customer.rentMovie(pulpFiction, 1);
		customer.rentMovie(pulpFiction, 2);
		customer.rentMovie(pulpFiction, 3);
		assertEquals(new Euro(7.75), customer.getTotalCharge());
	}

	@Test
	public void testRentingFourMovies() {
		customer.rentMovie(pulpFiction, 1);
		customer.rentMovie(pulpFiction, 2);
		customer.rentMovie(pulpFiction, 3);
		customer.rentMovie(pulpFiction, 4);
		assertEquals(new Euro(13.25), customer.getTotalCharge());
	}
}
