package Euro;

public final class Euro {
	private final long cents;
	
	public Euro(double amount) {
		cents = Math.round(amount*100);
	}
	
	private Euro(long cents) {
		this.cents = cents;
	}

	public double getAmount() {
		return cents / 100;
	}
	
	public Euro add(Euro other) { // was bei negativen Beträgen?
		return new Euro(cents + other.cents);
	}
}
