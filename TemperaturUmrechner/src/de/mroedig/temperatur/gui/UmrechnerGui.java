package de.mroedig.temperatur.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import de.mroedig.temperatur.TemperaturUmrechner;
import de.mroedig.temperatur.exceptions.TemperaturZuGeringException;

public class UmrechnerGui {

	private JPanel contentPane;
	private JTextField eingabe;
	private JTextField ausgabeLinks;
	private JTextField ausgabeRechts;
	private JPanel inneresPanel;
	private JFrame hauptGui;
	private JPanel unteresPanel;

	public void los() {
		hauptGui = new JFrame("Temperaturumrechner");
		contentPane = new JPanel();
		konfiguriereDieGui();
		erstelleContent();
	}

	private void konfiguriereDieGui() {
		hauptGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hauptGui.setBounds(100, 100, 318, 135);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		hauptGui.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		hauptGui.setVisible(true);
	}

	private void erstelleContent() {
		erstelleRadioButtons(erstelleInneresPanel());
		erstelleTextfelder();
	}

	private JPanel erstelleInneresPanel() {
		unteresPanel = new JPanel();
		contentPane.add(unteresPanel, BorderLayout.CENTER);
		return unteresPanel;
	}

	private void erstelleTextfelder() {
		eingabe = new JTextField();
		contentPane.add(eingabe, BorderLayout.NORTH);
		eingabe.setColumns(10);

		inneresPanel = new JPanel();
		contentPane.add(inneresPanel, BorderLayout.SOUTH);
		inneresPanel.setLayout(new GridLayout(0, 2, 0, 0));

		ausgabeLinks = new JTextField();
		ausgabeLinks.setEditable(false);
		inneresPanel.add(ausgabeLinks);
		ausgabeLinks.setColumns(10);
		ausgabeRechts = new JTextField();
		ausgabeRechts.setEditable(false);
		inneresPanel.add(ausgabeRechts);
		ausgabeRechts.setColumns(10);
	}

	private void erstelleRadioButtons(JPanel panel) {

		ButtonGroup radioButtons = new ButtonGroup();
		unteresPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JRadioButton fahrenheitRadio = new JRadioButton("Fahrenheit");
		panel.add(fahrenheitRadio);

		JRadioButton celsiusRadio = new JRadioButton("Celsius");
		panel.add(celsiusRadio);

		JRadioButton kelvinRadio = new JRadioButton("Kelvin");
		panel.add(kelvinRadio);

		fahrenheitRadio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ausgabeLinks.setText(TemperaturUmrechner
							.rechneFahrenheitToCelsius(eingabe.getText()) + "C");
				} catch (NumberFormatException e1) {
					ausgabeLinks.setText("Eingabeformat falsch");
				} catch (TemperaturZuGeringException e1) {
					ausgabeRechts.setText(e1.getMessage());
				}
				try {
					ausgabeRechts.setText(TemperaturUmrechner
							.rechneFahrenheitToKelvin(eingabe.getText()) + "K");
				} catch (NumberFormatException e1) {
					ausgabeRechts.setText("Eingabeformat falsch");
				} catch (TemperaturZuGeringException e1) {
					ausgabeRechts.setText(e1.getMessage());
				}
			}
		});

		kelvinRadio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ausgabeLinks.setText(TemperaturUmrechner
							.rechneKelvinToCelsius(eingabe.getText()) + "C");
				} catch (NumberFormatException e1) {
					ausgabeLinks.setText("Eingabeformat falsch");
				}
				try {
					ausgabeRechts.setText(TemperaturUmrechner
							.rechneKelvinToFahrenheit(eingabe.getText()) + "F");
				} catch (NumberFormatException e1) {
					ausgabeRechts.setText("Eingabeformat falsch");
				} catch (TemperaturZuGeringException e1) {
					ausgabeRechts.setText(e1.getMessage());
				}
			}
		});

		celsiusRadio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ausgabeLinks.setText(TemperaturUmrechner
							.rechneCelsiusToFahrenheit(eingabe.getText()) + "F");
				} catch (NumberFormatException e1) {
					ausgabeLinks.setText("Eingabeformat falsch");
				} catch (TemperaturZuGeringException e1) {
					ausgabeLinks.setText(e1.getMessage());
				}
				try {
					ausgabeRechts.setText(TemperaturUmrechner
							.rechneCelsiusToKelvin(eingabe.getText()) + "K");
				} catch (NumberFormatException e1) {
					ausgabeRechts.setText("Eingabeformat falsch");
				} catch (TemperaturZuGeringException e1) {
					ausgabeRechts.setText(e1.getMessage());
				}
			}
		});
		radioButtons.add(kelvinRadio);
		radioButtons.add(fahrenheitRadio);
		radioButtons.add(celsiusRadio);
	}

}
