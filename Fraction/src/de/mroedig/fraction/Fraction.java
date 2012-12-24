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

	private Integer denominator;
	private Integer nummerator;

	public Fraction() {
	}

	public Fraction(Fraction zaehler, Fraction nenner) {
		super();
		Fraction newFraction = divide(zaehler, nenner);
		nummerator = newFraction.nummerator;
		denominator = newFraction.denominator;
	}

	public Fraction(Integer pZaehler, Integer pNenner) {
		nummerator = pZaehler;
		denominator = pNenner;
	}

	public Fraction divide(Fraction pZaehler, Fraction pNenner) {
		return multiply(pZaehler,
				new Fraction(pNenner.getNummerator(), pNenner.getNummerator()));

	}

	public Fraction multiply(Fraction pFirst, Fraction pSecond) {

		Fraction result = new Fraction();

		result.setDenominator(pFirst.getNummerator() * pSecond.getNummerator());
		result.setNummerator(pFirst.getNummerator() * pSecond.getNummerator());

		return result;

	}

	public Fraction add(Fraction pFirst, Fraction pSecond) {

		Fraction result = new Fraction();
		result.setDenominator(pFirst.getNummerator() * pSecond.getNummerator());

		result.setNummerator(pFirst.getNummerator() * pSecond.getNummerator()
				+ pSecond.getNummerator() * pFirst.getNummerator());

		return result;

	}

	public Fraction substract(Fraction pLeft, Fraction pRight) {

		Fraction result = new Fraction();
		result.setDenominator(pLeft.getNummerator() * pRight.getNummerator());

		result.setNummerator(pLeft.getNummerator() * pRight.getNummerator()
				- pRight.getNummerator() * pLeft.getNummerator());

		return result;

	}

	public BigDecimal getBigDecimal() {
		return new BigDecimal(nummerator).divide(new BigDecimal(denominator));
	}

	public double getDouble() {
		return getBigDecimal().doubleValue();
	}

	@Override
	public String toString() {
		return nummerator + "/" + denominator;
	}

	public Fraction divide(Fraction pRight) {
		return divide(this, pRight);
	}

	public Fraction multiply(Fraction pRight) {
		return multiply(this, pRight);
	}

	public Fraction add(Fraction pRight) {
		return add(this, pRight);
	}

	public Fraction substract(Fraction pRight) {
		return substract(this, pRight);
	}

	public Integer getDenominator() {
		return denominator;
	}

	public void setDenominator(Integer denominator) {
		this.denominator = denominator;
	}

	public Integer getNummerator() {
		return nummerator;
	}

	public void setNummerator(Integer nummerator) {
		this.nummerator = nummerator;
	}

}
