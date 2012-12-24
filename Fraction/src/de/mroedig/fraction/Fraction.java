package de.mroedig.fraction;

/**
 * @author mroedig please have a look at: goo.gl/wxzpT support me please, and
 *         give some coins
 * 
 *         This file is part of the de.mroedig.Fraction library.
 * 
 *         Fraction is free software: you can redistribute it and/or modify it
 *         under the terms of the GNU General Public License as published by the
 *         Free Software Foundation, either version 3 of the License, or (at
 *         your option) any later version.
 * 
 *         Fraction is distributed in the hope that it will be useful, but
 *         WITHOUT ANY WARRANTY; without even the implied warranty of
 *         MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *         General Public License for more details.
 * 
 *         You should have received a copy of the GNU General Public License
 *         along with Fraction. If not, see <http://www.gnu.org/licenses/>.
 * 
 *         Diese Datei ist Teil der de.mroedig.Fraction Bibliothek.
 * 
 *         Fraction ist Freie Software: Sie können es unter den Bedingungen der
 *         GNU General Public License, wie von der Free Software Foundation,
 *         Version 3 der Lizenz oder (nach Ihrer Option) jeder späteren
 *         veröffentlichten Version, weiterverbreiten und/oder modifizieren.
 * 
 *         Fraction wird in der Hoffnung, dass es nützlich sein wird, aber OHNE
 *         JEDE GEWÄHRLEISTUNG, bereitgestellt; sogar ohne die implizite
 *         Gewährleistung der MARKTFÄHIGKEIT oder EIGNUNG FÜR EINEN BESTIMMTEN
 *         ZWECK. Siehe die GNU General Public License für weitere Details.
 * 
 *         Sie sollten eine Kopie der GNU General Public License zusammen mit
 *         diesem Programm erhalten haben. Wenn nicht, siehe
 *         <http://www.gnu.org/licenses/>.
 */
import java.math.BigDecimal;

public class Fraction {

	private Integer nenner;
	private Integer zaehler;

	public Fraction() {
	}

	public Fraction(Fraction zaehler, Fraction nenner) {
		super();
		Fraction newFraction = divide(zaehler, nenner);
		this.zaehler = newFraction.zaehler;
		this.nenner = newFraction.nenner;
	}

	public Fraction(Integer pZaehler, Integer pNenner) {
		zaehler = pZaehler;
		nenner = pNenner;
	}

	public Fraction divide(Fraction pZaehler, Fraction pNenner) {
		return multiply(pZaehler,
				new Fraction(pNenner.getNenner(), pNenner.getZaehler()));

	}

	public Fraction multiply(Fraction pFirst, Fraction pSecond) {

		Fraction result = new Fraction();

		result.setNenner(pFirst.getNenner() * pSecond.getNenner());
		result.setZaehler(pFirst.getZaehler() * pSecond.getZaehler());

		return result;

	}

	public Fraction add(Fraction pFirst, Fraction pSecond) {

		Fraction result = new Fraction();
		result.setNenner(pFirst.getNenner() * pSecond.getNenner());

		result.setZaehler(pFirst.getZaehler() * pSecond.getNenner()
				+ pSecond.getZaehler() * pFirst.getNenner());

		return result;

	}

	public Fraction substract(Fraction pFirst, Fraction pSecond) {

		Fraction result = new Fraction();
		result.setNenner(pFirst.getNenner() * pSecond.getNenner());

		result.setZaehler(pFirst.getZaehler() * pSecond.getNenner()
				- pSecond.getZaehler() * pFirst.getNenner());

		return result;

	}

	public BigDecimal getBigDecimal() {
		return new BigDecimal(zaehler).divide(new BigDecimal(nenner));
	}

	public double getDouble() {
		return getBigDecimal().doubleValue();
	}

	@Override
	public String toString() {
		return zaehler + "/" + nenner;
	}

	public Integer getNenner() {
		return nenner;
	}

	public Integer getZaehler() {
		return zaehler;
	}

	public void setNenner(Integer nenner) {
		this.nenner = nenner;
	}

	public void setZaehler(Integer zaehler) {
		this.zaehler = zaehler;
	}

	public Fraction divide(Fraction rechts) {
		return divide(this, rechts);
	}

	public Fraction multiply(Fraction rechts) {
		return multiply(this, rechts);
	}

	public Fraction add(Fraction rechts) {
		return add(this, rechts);
	}

	public Fraction substract(Fraction rechts) {
		return substract(this, rechts);
	}

}
