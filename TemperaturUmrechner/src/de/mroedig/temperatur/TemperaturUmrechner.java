package de.mroedig.temperatur;

import de.mroedig.temperatur.exceptions.TemperaturZuGeringException;

public class TemperaturUmrechner {

	public static double rechneFahrenheitToCelsius(double wert)
			throws TemperaturZuGeringException {

		double ergebnis = wert * 1.8 + 32;
		if (wert < -273.15) {
			throw new TemperaturZuGeringException("Temperatur ist zu gering");
		}
		return ergebnis;
	}

	public static double rechneCelsiusToFahrenheit(double wert)
			throws TemperaturZuGeringException {
		if (wert < -273.15) {
			throw new TemperaturZuGeringException("Temperatur ist zu gering");
		}
		return (wert - 32) * 5 / 9.0;
	}

	public static double rechneCelsiusToKelvin(double wert)
			throws TemperaturZuGeringException {
		if (wert < -273.15) {
			throw new TemperaturZuGeringException("Temperatur ist zu gering");
		}
		return wert + 273.15;
	}

	public static double rechneKelvinToCelsius(double wert) {
		return wert - 273.15;
	}

	public static double rechneKelvinToFahrenheit(double wert)
			throws TemperaturZuGeringException {
		return rechneCelsiusToFahrenheit(rechneKelvinToCelsius(wert));
	}

	public static double rechneFahrenheitToKelvin(double wert)
			throws TemperaturZuGeringException {
		return rechneCelsiusToKelvin(rechneFahrenheitToCelsius(wert));
	}

	public static String rechneFahrenheitToCelsius(String wert)
			throws NumberFormatException, TemperaturZuGeringException {

		return formatiereDoubleToString(rechneFahrenheitToCelsius(Double
				.parseDouble(wert)));
	}

	public static String rechneCelsiusToFahrenheit(String wert)
			throws NumberFormatException, TemperaturZuGeringException {

		return formatiereDoubleToString(rechneCelsiusToFahrenheit(Double
				.parseDouble(wert)));

	}

	public static String rechneCelsiusToKelvin(String wert)
			throws TemperaturZuGeringException {

		return formatiereDoubleToString(rechneCelsiusToKelvin(Double
				.parseDouble(wert)));
	}

	public static String rechneKelvinToCelsius(String wert) {
		return formatiereDoubleToString(rechneKelvinToCelsius(Double
				.parseDouble(wert)));
	}

	public static String rechneKelvinToFahrenheit(String wert)
			throws NumberFormatException, TemperaturZuGeringException {
		return formatiereDoubleToString(rechneKelvinToFahrenheit(Double
				.parseDouble(wert)));
	}

	public static String rechneFahrenheitToKelvin(String wert)
			throws TemperaturZuGeringException {
		return formatiereDoubleToString(rechneFahrenheitToKelvin(Double
				.parseDouble(wert)));
	}

	public static String formatiereDoubleToString(Double eingabe) {
		return String.format("%1$,.2f", eingabe);
	}
}
