package persist.util;

public enum FeedingType {
	CARNIVAORE("carnivore"), HERBIVORE("herbivore");

	private final String text;

	FeedingType(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
