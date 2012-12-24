package de.mroedig.fraction.exceptions;

public class FractionDivisionByZeroException extends Exception {

	private static final long serialVersionUID = -6634723288119681965L;

	public FractionDivisionByZeroException() {

		super("Division by Zero");
	}

}
