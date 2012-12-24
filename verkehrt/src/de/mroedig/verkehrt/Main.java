package de.mroedig.verkehrt;

import javax.swing.JOptionPane;

import de.mroedig.rueckwaerts.Rueckwaerts;

public class Main {
	public static void main(String[] args) {

		String eingabe = JOptionPane
				.showInputDialog("Bitte geben Sie die Anzahl an Buchstaben ein.");
		int n = Integer.parseInt(eingabe);
		String array = JOptionPane
				.showInputDialog("Bitte geben Sie die Buchstaben ein.");
		System.out.println(Rueckwaerts.rueckwarts(array.toCharArray()));

	}
}
