package com.stream.exceptions;

public class LoginException extends Exception{

    public LoginException() {
        super("Username or password incorrect");
    }
}
