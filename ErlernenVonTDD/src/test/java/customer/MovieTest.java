package customer;

import static org.junit.Assert.*;

import org.junit.Test;

import Euro.Euro;

public class MovieTest {

	@Test
	public void testUsingNewReleasePrice() {
		Movie movie = new Movie("Fight Club", Price.NEWRELEASE);
		assertEquals(new Euro(3.75), movie.getCharge(3));
	}

	@Test
	public void testSettingNewPrice() {
		Movie movie = new Movie("Brazil", Price.NEWRELEASE);
		movie.setPrice(Price.REGULAR);
		assertEquals(new Euro(1.50), movie.getCharge(3));
	}
	
	public void testUsingStubPrice() {
		Movie movie = new Movie("Stub Movie", new StubPrice());
		assertEquals(new Euro(2.00), movie.getCharge(3));
		}
}
