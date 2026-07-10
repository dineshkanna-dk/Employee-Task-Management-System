package com.employee.taskmanagement.exception;

public class DuplicateTaskException extends RuntimeException {

    public DuplicateTaskException(String message) {
        super(message);
    }
}