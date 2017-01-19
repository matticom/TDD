package customer;

import Euro.Euro;

public class Movie {

	private String title;
	private Price price;
	
	public Movie() {
	}
	
	public Movie(String title, Price price) {
		this.title = title;
		this.price = price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}

	public Euro getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}
}