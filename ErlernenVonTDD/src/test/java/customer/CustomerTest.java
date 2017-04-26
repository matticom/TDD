package customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import Euro.Euro;

public class CustomerTest {

	private Customer customer;

	private Movie buffalo66, jungleBook, pulpFiction;
//	private String printerOutput;
	private MockPrinter mockPrinter;

	
	@Before
	public void setUp() {
		customer = new Customer();

		buffalo66 = new Movie("Buffalo 66", new StubPrice());
		jungleBook = new Movie("Das Dschungelbuch", Price.REGULAR);
		pulpFiction = new Movie("Pulp Fiction", Price.NEWRELEASE);
		mockPrinter = new MockPrinter();
	}

	@Test
	public void testPrintingStatement() throws Exception {
		mockPrinter.addExpectedOutput("Buffalo 66");
		mockPrinter.addExpectedOutput("3,00");
		mockPrinter.addExpectedOutput("Das Dschungelbuch");
		mockPrinter.addExpectedOutput("1,50");
		mockPrinter.addExpectedOutput("Pulp Fiction");
		mockPrinter.addExpectedOutput("5,50");
		mockPrinter.addExpectedOutput("Gesamt: 10,00");

		
		mockPrinter.setExpectedTabCalls(6);
		mockPrinter.setExpectedCrlfCalls(4);
		mockPrinter.setExpectedCutPaperCalls(1);
		
		customer.rentMovie(buffalo66, 4);
		customer.rentMovie(jungleBook, 1);
		customer.rentMovie(pulpFiction, 4);
		buffalo66.setPrice(Price.REGULAR);
		customer.printStatement(mockPrinter);
		mockPrinter.verify();
//		String expected = "\tBuffalo 66\t3,00\n" + "\tDas Dschungelbuch\t1,50\n" + "\tPulp Fiction\t5,50\n" + "Gesamt: 10,00\n";
//		System.out.println(expected);
//		System.out.println(printerOutput);

	}
	
	@Test
	public void testStatementDetailForRentalDetails() throws Exception {
		mockPrinter.addExpectedOutput("Buffalo 66");
		mockPrinter.addExpectedOutput("2,00");
		mockPrinter.addExpectedOutput("Gesamt: 2,00");
			
		mockPrinter.setExpectedTabCalls(2);
		mockPrinter.setExpectedCrlfCalls(2);
		mockPrinter.setExpectedCutPaperCalls(1);
		
		customer.rentMovie(buffalo66, 1);
		customer.printStatement(mockPrinter);
		mockPrinter.verify();
//		printerOutput.verify();
//		assertEquals("\tBuffalo 66\t2,00\n"	+ "Gesamt: 2,00\n", printerOutput);
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
