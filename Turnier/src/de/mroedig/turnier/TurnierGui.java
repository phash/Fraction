package de.mroedig.turnier;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TurnierGui {

	private final JFrame gui;

	private final JTable paarungTable;
	private final JTable teamTable;
	private final JScrollPane teamScrollPane;
	private final JScrollPane paarScrollPane;
	private final PaarungTableModel paarungModel = new PaarungTableModel();
	private final TeamTableModel teamModel = new TeamTableModel();
	private final JButton naechsteRunde;

	public TurnierGui() {
		gui = new JFrame("Turnier");
		gui.getContentPane().setBounds(new Rectangle(0, 0, 620, 220));

		JPanel panel = new JPanel();
		gui.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		final JButton btnAuslosen = new JButton("auslosen");
		panel.add(btnAuslosen, BorderLayout.SOUTH);

		teamScrollPane = new JScrollPane();
		paarScrollPane = new JScrollPane();

		panel.add(teamScrollPane, BorderLayout.WEST);

		teamTable = new JTable(teamModel);
		teamScrollPane.setViewportView(teamTable);

		paarungTable = new JTable(paarungModel);
		paarScrollPane.setViewportView(paarungTable);
		// panel.add(paarungTable, BorderLayout.EAST);

		panel.add(paarScrollPane, BorderLayout.CENTER);

		naechsteRunde = new JButton("New button");
		naechsteRunde.setVisible(false);
		panel.add(naechsteRunde, BorderLayout.NORTH);

		btnAuslosen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isAuslosenMoeglich()) {
					auslosen();
				} else {
					btnAuslosen.setVisible(false);
					naechsteRunde.setVisible(true);
				}
			}

		});
		naechsteRunde.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setzeNaechsteRunde();
				btnAuslosen.setVisible(true);
				naechsteRunde.setVisible(false);
			}
		});

		gui.setBounds(100, 100, 750, 459);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}

	protected boolean isAuslosenMoeglich() {
		return teamTable.getModel().getRowCount() > 1;
	}

	public void start() {
	}

	private void setzeNaechsteRunde() {
		List<Team> winnerList = new ArrayList<>();
		try {
			for (Paarung element : paarungModel.getList()) {
				winnerList.add(element.getWinner());
			}
		} catch (UnentschiedenException e) {
			e.printStackTrace();
		}
		teamModel.setzeNeu(winnerList);
	}

	private void auslosen() {

		if (isAuslosenMoeglich()) {

			int random = (int) (Math.random() * teamTable.getRowCount());
			Team heim = teamModel.getZeile(random);
			teamModel.remove(random);

			random = (int) (Math.random() * teamTable.getRowCount());
			Team gast = teamModel.getZeile(random);
			teamModel.remove(random);

			Paarung paarung = new Paarung(heim, gast);

			paarungModel.addPaarung(paarung);

		}
	}
}
