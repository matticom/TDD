package customer;

import Euro.Euro;

public class Price {
	
	public final static Price NEWRELEASE = new Price(new Euro(2.00), new Euro(1.75), 2);
	public final static Price REGULAR =	new Price(new Euro(1.50), new Euro(1.50), 3);
	
	private Euro basePrice = new Euro(1.50);
	private Euro pricePerDay = new Euro(1.50);
	private int daysDiscounted = 3;

	Price(Euro basePrice, Euro pricePerDay, int daysDiscounted) {
		this.basePrice = basePrice;
		this.pricePerDay = pricePerDay;
		this.daysDiscounted = daysDiscounted;
	}

	public Euro getCharge(int daysRented) {
		if (daysRented <= daysDiscounted)
			return basePrice;
		int additionalDays = daysRented - daysDiscounted;
		return basePrice.plus(pricePerDay.times(additionalDays));
	}
}
