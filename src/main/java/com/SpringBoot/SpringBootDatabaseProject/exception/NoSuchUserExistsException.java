package com.SpringBoot.SpringBootDatabaseProject.exception;

public class NoSuchUserExistsException extends RuntimeException {

    private String message;

    public NoSuchUserExistsException() {
    }

    public NoSuchUserExistsException(String message) {
        super(message);
        this.message = message;
    }
}
