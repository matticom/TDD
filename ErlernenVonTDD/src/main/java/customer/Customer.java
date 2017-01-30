package customer;

import java.util.ArrayList;
import java.util.List;

import Euro.Euro;

public class Customer {

	private Movie movie;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer() {
		movie = new Movie();
	}

	public void rentMovie(Movie movie, int daysRented) {
		if (daysRented == 0) {
			return;
		}
		rentals.add(new Rental(movie, daysRented));
	}

	public void printStatement(IPrinter printer) throws OutOfPaperException {
		for (Rental rental : rentals) {
			printer.tab();
			printer.print(rental.getMovieTitle());
			printer.tab();
			printer.print(rental.getCharge().format());
			printer.crlf();
		}
		printer.print("Gesamt: " + getTotalCharge().format());
		printer.crlf();
		printer.cutPaper();
	}

	public Euro getTotalCharge() {
		Euro result = new Euro(0);
		for (Rental rental : rentals) {
			result = result.plus(rental.getCharge());
		}
		return result;
	}
}
