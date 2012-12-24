package de.mroedig.turnier;

import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TeamTableModel implements TableModel {

	private final Vector<Team> teams = new Vector<>();

	private final Vector<TableModelListener> listeners = new Vector<>();

	public TeamTableModel() {
		// hier koennte man nun aus der DB laden, haben wir aber nicht, deswegen
		// mit der Hand - die Namen sind Namen beruehmter Persoenlichkeiten, und
		// alle haben ein Team in unserem Turnier
		String[] teamNamen = new String[] { "Piaget", "Bierbaum", "Christie",
				"Zeller", "Gide", "Morgenstern", "Grönemeyer", "Mozart",
				"Weidner", "Madariaga", "Marti", "Phelps", "Schleiermacher",
				"Galilei", "Clara", "Churchill", "Nin", "Ebner-Eschenbach",
				"Strack", "Hepburn", "Brockes", "Fürstenberg", "Butterworth",
				"Hope", "Henschke", "Becker", "Young", "Cassirer", "Radecki",
				"Alexander", "Barrault", "Pananti", "Liebig",
				"Talleyrand-Périgord", "Schmeling", "Cocteau", "Braunschweig",
				"Johnson", "Nestroy", "Pindar", "Matthau", "Achard",
				"Anacharsis", "Ambrosius", "Mailand", "Stifter", "Bauer",
				"Armstrong", "Dall", "Gutzkow", "O'Malley" };
		for (int i = 0; i < 4; i++) {
			teams.add(new Team(teamNamen[i]));
		}
	}

	public void addTeam(Team team) {
		int index = teams.size();
		teams.add(team);

		TableModelEvent e = new TableModelEvent(this, index, index,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);

		for (int i = 0, n = listeners.size(); i < n; i++) {
			listeners.get(i).tableChanged(e);
		}
	}

	@Override
	public int getRowCount() {
		return teams.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Name";
		case 1:
			return "Punkte";

		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return Integer.class;

		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return false;
		case 1:
			return false;
		default:
			return false;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Team team = teams.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return team.getName();
		case 1:
			return new Integer(team.getPunkte());
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}

	public void remove(int zeile) {
		teams.remove(zeile);

		TableModelEvent e = new TableModelEvent(this, zeile, zeile,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);

		for (int i = 0, n = listeners.size(); i < n; i++) {
			listeners.get(i).tableChanged(e);
		}
	}

	public Team getZeile(int index) {
		return teams.get(index);
	}

	public void setzeNeu(List<Team> winnerList) {
		for (Team team : winnerList) {
			addTeam(team);
		}

	}

}
