package customer;

import Euro.Euro;

public class RegularPrice {

	private static final Euro BASEPRICE = new Euro(1.50);
	private static final Euro PRICE_PER_DAY = new Euro(1.50);
	private static final int DAYS_DISCOUNTED = 3;

	public Euro getCharge(int daysRented) {
		if (daysRented <= DAYS_DISCOUNTED) return BASEPRICE;
		int additionalDays = daysRented - DAYS_DISCOUNTED;
		return BASEPRICE.plus(PRICE_PER_DAY.times(additionalDays));
	}
	
	
}
