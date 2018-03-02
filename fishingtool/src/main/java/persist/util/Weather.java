package persist.util;

public enum Weather {
	RAINING(1), SNOWING(2), CLOUDY(3), SUNNY(4);

	private final int num;

	private Weather(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return String.valueOf(num);
	}
}
