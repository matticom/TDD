package customer;

public class Customer {
	double totalCharge;
	Movie movie;
	
	public Customer() {
		totalCharge = 0;
		movie = new Movie();
	}
	
	public void rentMovie(int daysRented) {
		
		totalCharge += movie.getCharge(daysRented);
	}

	public double getTotalCharge() {
		return totalCharge;
	}
}
