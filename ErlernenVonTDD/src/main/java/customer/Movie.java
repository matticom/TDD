package customer;

import Euro.Euro;

public class Movie {

	public static Euro getCharge(int daysRented) {
		return NewReleasePrice.tmpCharge(daysRented);
	}
	
	
}