package util;

public enum BaitType {
	NATURAL("natural"), ARTIFICIAL("artificial");

	private final String text;

	BaitType(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
