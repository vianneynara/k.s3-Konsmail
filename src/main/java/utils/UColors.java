package utils;

/**
 * This enum class is used to store the colors that will be used in the application. The colors are represented using
 * hexadecimal values.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public enum UColors {
	MAROON("0x952323"),
	RED("0xA73121"),
	BEIGE("0xDAD4B5"),
	IVORY("0xF2E8C6");

	private final String colorHex;

	UColors(String colorHex) {
		this.colorHex = colorHex;
	}

	@Override
	public String toString() {
		return this.colorHex;
	}
}
