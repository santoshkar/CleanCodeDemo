package com.example.demo;

public class EmptyDepartmentException extends Exception {

	private static final long serialVersionUID = -5669462450630882040L;

	public EmptyDepartmentException() {
		super();
	}

	public EmptyDepartmentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmptyDepartmentException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyDepartmentException(String message) {
		super(message);
	}

	public EmptyDepartmentException(Throwable cause) {
		super(cause);
	}
}
