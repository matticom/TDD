package Euro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EuroTest {

	private Euro two;

	@Before
	public void setUp() {
		two = new Euro(2.00);
	}

	@Test
	public void testAmount() {
		assertTrue(2.00 == two.getAmount());
	}

	@Test
	public void testRounding() {
		Euro rounded = new Euro(1.995);
		assertEquals("amount not rounded", two, rounded);
	}

	@Test
	public void testAdding() {
		Euro sum = two.plus(two);
		assertEquals("sum", new Euro(4), sum);
		assertEquals("two", new Euro(2), two);
	}

	@Test
	public void testEquality() {
		assertEquals(two, two);
		assertEquals(two, new Euro(2.00));
		assertEquals(new Euro(2.00), two);
		assertFalse(two.equals(new Euro(7.00)));
		assertFalse(two.equals(null));
		assertFalse(two.equals(new Object()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeAmount() {
		final double NEGATIVE_AMOUNT = -2.00;
		new Euro(NEGATIVE_AMOUNT);
		fail("amount must not be negative");
	}

	@Test
	public void testMultiplying() {
		Euro result = two.times(7);
		assertEquals(new Euro(14.00), result);
		assertEquals(new Euro(2.00), two);
	}

}
