package persist.util;

public enum DayTime {
	MORNING(1), FORENOON(2), MIDDAY(3), AFTERNOON(4), EVENING(5), NIGHT(6);

	private final int num;

	DayTime(final int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return String.valueOf(num);
	}

}
