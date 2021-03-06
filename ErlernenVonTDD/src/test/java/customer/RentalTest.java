package customer;

import static org.junit.Assert.*;

import org.junit.Test;

import Euro.Euro;

public class RentalTest {

	@Test
	public void testUsingMovie() {
		Movie movie = new Movie("Blow-Up", Price.NEWRELEASE);
		Rental rental = new Rental(movie, 2);
		assertEquals(new Euro(2.00), rental.getCharge());
	}
}
