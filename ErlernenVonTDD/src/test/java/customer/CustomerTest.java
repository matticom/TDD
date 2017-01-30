package customer;

import org.junit.Before;
import org.junit.Test;

import com.mockobjects.ExpectationCounter;
import com.mockobjects.ExpectationList;
import com.mockobjects.util.Verifier;

import Euro.Euro;

public class CustomerTest extends junit.framework.TestCase implements IPrinter {

	private Customer customer;

	private Movie buffalo66, jungleBook, pulpFiction;
//	private String printerOutput;
	private ExpectationCounter tabCalls;
	private ExpectationCounter crlfCalls;
	private ExpectationCounter cutPaperCalls;
	
	private ExpectationList printerOutput;

	public void print(String output)  throws OutOfPaperException {
		printerOutput.addActual(output);
	}
	
	@Override
	public void tab() throws OutOfPaperException {
		tabCalls.inc();
	}

	@Override
	public void crlf() throws OutOfPaperException {
		crlfCalls.inc();
	}

	@Override
	public void cutPaper() throws OutOfPaperException {
		cutPaperCalls.inc();
	}


	@Before
	public void setUp() {
		customer = new Customer();

		buffalo66 = new Movie("Buffalo 66", new StubPrice());
		jungleBook = new Movie("Das Dschungelbuch", Price.REGULAR);
		pulpFiction = new Movie("Pulp Fiction", Price.NEWRELEASE);
		
		printerOutput = new ExpectationList("printer output");
		tabCalls = new ExpectationCounter("tab() calls");
		crlfCalls = new ExpectationCounter("crlf() calls");
		cutPaperCalls = new ExpectationCounter("cutPaper() calls");
	}

	@Test
	public void testPrintingStatement() throws Exception {
		printerOutput.addExpected("Buffalo 66");
		printerOutput.addExpected("3,00");
		printerOutput.addExpected("Das Dschungelbuch");
		printerOutput.addExpected("1,50");
		printerOutput.addExpected("Pulp Fiction");
		printerOutput.addExpected("5,50");
		printerOutput.addExpected("Gesamt: 10,00");

		
		tabCalls.setExpected(6);
		crlfCalls.setExpected(4);
		cutPaperCalls.setExpected(1);
		
		customer.rentMovie(buffalo66, 4);
		customer.rentMovie(jungleBook, 1);
		customer.rentMovie(pulpFiction, 4);
		buffalo66.setPrice(Price.REGULAR);
		customer.printStatement(this);
//		String expected = "\tBuffalo 66\t3,00\n" + "\tDas Dschungelbuch\t1,50\n" + "\tPulp Fiction\t5,50\n" + "Gesamt: 10,00\n";
//		System.out.println(expected);
//		System.out.println(printerOutput);
		Verifier.verifyObject(this);
	}
	
	@Test
	public void testStatementDetailForRentalDetails() throws Exception {
		printerOutput.addExpected("Buffalo 66");
		printerOutput.addExpected("2,00");
		printerOutput.addExpected("Gesamt: 2,00");
			
		tabCalls.setExpected(2);
		crlfCalls.setExpected(2);
		cutPaperCalls.setExpected(1);
		
		customer.rentMovie(buffalo66, 1);
		customer.printStatement(this);
		Verifier.verifyObject(this);
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
