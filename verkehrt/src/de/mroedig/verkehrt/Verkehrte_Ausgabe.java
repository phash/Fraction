package de.mroedig.verkehrt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Verkehrte_Ausgabe {
	public static void main(String args[]) throws IOException {
		int[] array = new int[1];
		int[] reserveArray;
		int i = 0;
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));

		String zeile;
		System.out.println("los gehts");
		zeile = console.readLine();
		while (!(zeile.equals("") || zeile.equals("Ja") || zeile == null)) {
			if (array.length <= i) {
				array = Arrays.copyOf(array, array.length + 1);
			}

			int eingabe = Integer.parseInt(zeile);
			array[i] = eingabe;
			i++;
			System.out.println("Eingabe: ");
			zeile = console.readLine();
		}
		for (int x = array.length - 1; x >= 0; x--) {
			System.out.println(array[x]);
		}

	}
}