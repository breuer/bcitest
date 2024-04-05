package com.gl.usermicroservice.constants;

public class Constants {

	public static final String EMAIL_MALFORMED = "Email does not comply with the correct format";
	public static final String PASSWORD_MALFORMED = "Password does not comply with the correct format";
	public static final String REGEX_EMAIL = "^[a-zA-Z0-9_]+(?:\\.[a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+(?:\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,20}$";
	public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*\\d)(?=.*[a-z]).{8,12}$";
	public static final String USER_ALREADY_EXISTS = "There is an account with that email address";
	public static final String EMPTY_TOKEN = "Empty token";
	public static final String INVALID_TOKEN = "Invalid token";
}
