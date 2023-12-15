package utils;

import java.awt.Color;
import java.awt.Component;

/**
 * Utility class to store functions that modifies components.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public class ComponentUtils {
	/**
	 * Modifies the background color of the passed {@link Component}s using the passed {@link Color} simultaneously.
	 *
	 * @param color The color to be set.
	 * @param components The components to be modified.
	 * */
	public static void setBackgroundColor(Color color, Component... components) {
		for (Component component : components) {
			component.setBackground(color);
		}
	}

	/**
	 * Modifies the background color of the passed {@link Component}s using the passed hex code simultaneously.
	 *
	 * @param colorHex The hex color to be set.
	 * @param components The components to be modified.
	 * */
	public static void setBackgroundColor(int colorHex, Component... components) {
		// checks whether the hex format is valid
		if (colorHex < 0 || colorHex > 0xFFFFFF) {
			throw new IllegalArgumentException("Invalid hex format.");
		}
		Color color = new Color(colorHex);

		for (Component component : components) {
			component.setBackground(color);
		}
	}

	/**
	 * Modifies the foreground color of the passed {@link Component}s using the passed {@link Color} simultaneously.
	 *
	 * @param color The color to be set.
	 * @param components The components to be modified.
	 * */
	public static void setForegroundColor(Color color, Component... components) {
		for (Component component : components) {
			component.setForeground(color);
		}
	}

	/**
	 * Modifies the foreground color of the passed {@link Component}s using the passed hex code simultaneously.
	 *
	 * @param colorHex The hex color to be set.
	 * @param components The components to be modified.
	 * */
	public static void setForegroundColor(int colorHex, Component... components) {
		// checks whether the hex format is valid
		if (colorHex < 0 || colorHex > 0xFFFFFF) {
			throw new IllegalArgumentException("Invalid hex format.");
		}
		Color color = new Color(colorHex);

		for (Component component : components) {
			component.setForeground(color);
		}
	}
}
