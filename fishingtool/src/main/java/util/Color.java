package util;

public enum Color {
	BLACK("schwarz"), RED("rot");

	private final String string;

	private Color(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return string;
	}

}
