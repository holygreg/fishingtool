package util;

public enum DayTime {
	MORNING("Morgens"), FORENOON("Vormittags"), MIDDAY("Mittags"), AFTERNOON("Nachmittags"), EVENING("Abend"), NIGHT("Nacht");

	private final String string;

	DayTime(final String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return string;
	}

}
