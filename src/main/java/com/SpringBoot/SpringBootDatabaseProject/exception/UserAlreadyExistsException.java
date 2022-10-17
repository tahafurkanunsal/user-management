package com.SpringBoot.SpringBootDatabaseProject.exception;

public class UserAlreadyExistsException extends RuntimeException {


    public UserAlreadyExistsException(String message) {
        super(message);

    }
}
