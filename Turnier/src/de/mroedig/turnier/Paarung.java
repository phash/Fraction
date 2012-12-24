package de.mroedig.turnier;

public class Paarung {

	private final Team heim;
	private final Team gast;

	public Paarung(Team heim, Team gast) {
		super();
		this.heim = heim;
		this.gast = gast;
	}

	public Team getHeim() {
		return heim;
	}

	public Team getGast() {
		return gast;
	}

	public Team getWinner() throws UnentschiedenException {
		if (heim.getPunkte() == gast.getPunkte()) {
			throw new UnentschiedenException("Unentschieden");
		}

		if (heim.getPunkte() > gast.getPunkte()) {
			return heim;
		}
		return gast;
	}
}
