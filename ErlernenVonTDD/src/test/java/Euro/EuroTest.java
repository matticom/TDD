package Euro;

import static org.junit.Assert.*;
import org.junit.Test;

public class EuroTest {

	@Test
	public void testAmount() {
		Euro two = new Euro(2.00);
		assertTrue(2.00 == two.getAmount());
	}

	@Test
	public void testRounding() {
		Euro rounded = new Euro(1.995);
		assertEquals(2.00, rounded.getAmount(), 0.001);
	}

	@Test
	public void testAdding() {
		Euro two = new Euro(2.00);
		Euro sum = two.add(two);
		assertEquals("sum", 4.00, sum.getAmount(), 0.001);
		assertEquals("two", 2.00, two.getAmount(), 0.001);
	}
}
