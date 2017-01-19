package customer;

import Euro.Euro;

public class Customer {
	Euro totalCharge;
	Movie movie;
	
	public Customer() {
		totalCharge = new Euro(0);
		movie = new Movie();
	}
	
	public void rentMovie(int daysRented) {
		if (daysRented == 0) {
			return;
		}
		Euro thisMovie = movie.getCharge(daysRented);
		totalCharge = totalCharge.plus(thisMovie);
	}

	public Euro getTotalCharge() {
		return totalCharge;
	}
}
