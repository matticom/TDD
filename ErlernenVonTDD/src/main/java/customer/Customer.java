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

	public String printStatement() {
		StringBuilder result = new StringBuilder("");
		for (Rental rental : rentals) {
			result.append("\t" + rental.getMovieTitle() + "\t" + rental.getCharge().format() + "\n");
		}
		result.append("Gesamt: " + getTotalCharge().format() + "\n");
		return result.toString();
	}

	public Euro getTotalCharge() {
		Euro result = new Euro(0);
		for (Rental rental : rentals) {
			result = result.plus(rental.getCharge());
		}
		return result;
	}
}
