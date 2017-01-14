package customer;

public class Customer {
	int totalCharge;
	
	public Customer() {
		totalCharge = 0;
	}
	
	public void rentMovie(int daysRented) {
		totalCharge = 2 * daysRented;
	}

	public int getTotalCharge() {
		return totalCharge;
	}
}
