package de.mroedig.turnier;

public class Team {

	private final String name;
	private int punkte;

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public String getName() {
		return name;
	}

	public Team(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
