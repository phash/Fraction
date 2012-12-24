package de.mroedig.turnier;

import java.awt.EventQueue;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new TurnierGui();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
