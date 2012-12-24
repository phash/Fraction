package de.mroedig.turnier;

import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class PaarungTableModel implements TableModel {
	private final Vector<Paarung> paarungen = new Vector<>();
	private final Vector<TableModelListener> listeners = new Vector<>();

	public void addPaarung(Paarung paarung) {
		int index = paarungen.size();
		paarungen.add(paarung);

		// Zuerst ein Event, "neue Row an der Stelle index" herstellen
		TableModelEvent e = new TableModelEvent(this, index, index,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);

		// Nun das Event verschicken
		for (int i = 0, n = listeners.size(); i < n; i++) {
			listeners.get(i).tableChanged(e);
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return paarungen.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Heim";
		case 1:
			return "HeimPunkte";
		case 2:
			return "Gast";
		case 3:
			return "GastPunkte";

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
		case 2:
			return String.class;
		case 3:
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
			return true;
		case 2:
			return false;
		case 3:
			return true;

		default:
			return false;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Paarung paar = paarungen.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return paar.getHeim().getName();
		case 1:
			return new Integer(paar.getHeim().getPunkte());
		case 2:
			return paar.getGast().getName();
		case 3:
			return new Integer(paar.getGast().getPunkte());
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		Paarung paar = paarungen.get(rowIndex);

		switch (columnIndex) {
		case 0:

			break;
		case 1:
			paar.getHeim().setPunkte((int) aValue);
			break;
		case 2:

			break;
		case 3:
			paar.getGast().setPunkte((int) aValue);
			break;
		}

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}

	public List<Paarung> getList() {
		// TODO Auto-generated method stub
		return paarungen;
	}

}
