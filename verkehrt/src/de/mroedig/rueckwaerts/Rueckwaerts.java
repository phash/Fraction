package de.mroedig.rueckwaerts;

public class Rueckwaerts {

	public static String rueckwarts(char[] eingabe) {
		String ausgabe1 = "";
		for (char element : eingabe) {
			ausgabe1 = ausgabe1 + element;
		}
		return ausgabe1;
	}

}
