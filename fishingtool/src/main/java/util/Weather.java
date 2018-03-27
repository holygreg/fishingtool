package util;

public enum Weather {
	RAINING("Regen"), SNOWING("Schnee"), CLOUDY("Wolken"), SUNNY("Sonne");

	private final String string;

	private Weather(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return string;
	}
}
