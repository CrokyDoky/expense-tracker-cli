package org.example.service;

public class InvalidExpenseException extends ExpenseTrackerException {
    public InvalidExpenseException(String message) {
        super(message);
    }
}
