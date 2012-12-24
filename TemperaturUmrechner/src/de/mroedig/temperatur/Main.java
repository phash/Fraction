package de.mroedig.temperatur;

import java.awt.EventQueue;

import de.mroedig.temperatur.gui.UmrechnerGui;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UmrechnerGui umrechner = new UmrechnerGui();
					umrechner.los();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
