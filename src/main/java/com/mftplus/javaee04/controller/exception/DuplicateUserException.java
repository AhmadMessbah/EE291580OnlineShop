package com.mftplus.javaee04.controller.exception;

public class DuplicateUserException extends Exception {
    public DuplicateUserException(String message) {
        super(message);
    }
}
