package org.example.service;

public class ExpenseNotFoundException extends ExpenseTrackerException {
    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
