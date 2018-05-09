package com.dbirtwell.business;

public class InvalidYearException extends IllegalArgumentException {
	private static final long serialVersionUID = 3530238720930342032L;

	public InvalidYearException(String message) {
        super(message);
    }

}