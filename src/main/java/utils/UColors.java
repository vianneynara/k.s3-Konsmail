package utils;

import java.awt.Color;

/**
 * This enum class is used to store the colors that will be used in the application. The colors are represented using
 * hexadecimal values.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public enum UColors {
	MAROON(0x952323),
	RED(0xA73121),
	BEIGE(0xDAD4B5),
	IVORY(0xF2E8C6),
	BRIGHT_GREEN(0x52fa58),
	BRIGHT_ORANGE(0xfaac46),
	BRIGHT_RED(0xf7584d);

	private final int colorHex;

	UColors(int colorHex) {
		this.colorHex = colorHex;
	}

	@Override
	public String toString() {
		return String.valueOf(this.colorHex);
	}

	public int getValue() {
		return this.colorHex;
	}

	public Color toColor() {
		return Color.decode(String.valueOf(this.colorHex));
	}
}
