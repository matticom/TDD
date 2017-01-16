package customer;

public class Movie {
	public final int BASE_PRICE = 2;
	public final int DISCOUNTED_DAYS = 2;
	public final double PRICE_PER_DAY = 1.75;

	public double getCharge(int daysRented) {
		
		if (daysRented==0) {
			return 0;
		}
		
		double charge = 0;
		
		charge += BASE_PRICE;
		
		if (daysRented > DISCOUNTED_DAYS) {
			charge += PRICE_PER_DAY * (daysRented-DISCOUNTED_DAYS);
		}
		return charge;
	}
}