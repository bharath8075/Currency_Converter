package com.example.currency_converter.exception;

public class CurrencyNotFoundException extends RuntimeException {
	public CurrencyNotFoundException(String message) {
		super(message);
	}

}
