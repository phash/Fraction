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

import junit.framework.Assert;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testFractionFractionFraction() {
		Fraction links = new Fraction(1, 1);
		Fraction rechts = new Fraction(2, 2);

		Fraction fraction = new Fraction(links, rechts);

		Assert.assertTrue(fraction.getDenominator() == 2);
		Assert.assertTrue(fraction.getNummerator() == 2);
	}

	@Test
	public void testFractionIntegerInteger() {
		Fraction fraction = new Fraction(1, 1);

		Assert.assertTrue(fraction.getDenominator() == 1);
		Assert.assertTrue(fraction.getNummerator() == 1);
	}

	@Test
	public void testDivide() {
		Fraction links = new Fraction(3, 2);
		Fraction rechts = new Fraction(4, 5);

		Fraction fraction = links.divide(rechts);

		Assert.assertTrue(fraction.getNummerator() == 15);
		Assert.assertTrue(fraction.getDenominator() == 8);
	}

	@Test
	public void testMultiply() {
		Fraction links = new Fraction(3, 2);
		Fraction rechts = new Fraction(4, 5);

		Fraction fraction = links.multiply(rechts);

		Assert.assertTrue(fraction.getNummerator() == 12);
		Assert.assertTrue(fraction.getDenominator() == 10);
	}

	@Test
	public void testAdd() {
		Fraction links = new Fraction(3, 2);
		Fraction rechts = new Fraction(4, 5);

		Fraction fraction = links.add(rechts);

		Assert.assertTrue(fraction.getNummerator() == 23);
		Assert.assertTrue(fraction.getDenominator() == 10);
	}

	@Test
	public void testSubstract() {
		Fraction links = new Fraction(3, 2);
		Fraction rechts = new Fraction(4, 5);

		Fraction fraction = links.substract(rechts);

		Assert.assertTrue(fraction.getNummerator() == 7);
		Assert.assertTrue(fraction.getDenominator() == 10);
	}

	@Test
	public void testGetBigDecimal() {
		BigDecimal expected = new BigDecimal(0.5);
		Fraction fraction = new Fraction(1, 2);
		Assert.assertTrue(fraction.getBigDecimal().equals(expected));
		Assert.assertTrue(0 == fraction.getBigDecimal().compareTo(expected));
	}

	@Test
	public void testGetDouble() {
		double expected = 0.5;
		Fraction fraction = new Fraction(1, 2);
		Assert.assertEquals(expected, fraction.getDouble(), 1);
	}

	@Test
	public void testToString() {
		Fraction fraction = new Fraction(3, 7);
		String actual = "3/7";
		Assert.assertEquals(fraction.toString(), actual);
	}

}
