package customer;

import Euro.Euro;

public class StubPrice implements IPrice {
	public Euro getCharge(int daysRented) {
		return new Euro(2.00);
	}
}
