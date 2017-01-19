package Euro;

public final class Euro {
	private final long cents;

	public Euro(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("negative amount");
		}
		cents = Math.round(amount * 100);
	}

	private Euro(long cents) {
		this.cents = cents;
	}

	public double getAmount() {
		return (double)cents / 100;
	}

	public Euro times(int factor) {
		return new Euro(cents * factor);
	}

	public Euro plus(Euro other) { // was bei negativen Betr�gen?
		return new Euro(cents + other.cents);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cents ^ (cents >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Euro other = (Euro) obj;
		if (cents != other.cents)
			return false;
		return true;

	}

	@Override
	public String toString() {
		return "EUR " + getAmount();
	}

}
