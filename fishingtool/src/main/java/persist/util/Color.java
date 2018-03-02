package persist.util;

public enum Color {
	BLACK(1), RED(2);

	private final int num;

	private Color(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return String.valueOf(num);
	}

}
