package io.gdiazs.banking.accounts;

public class AccountsException extends Exception{

	private static final long serialVersionUID = 1L;

	public AccountsException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountsException(String message) {
		super(message);

	}

	
	
}
