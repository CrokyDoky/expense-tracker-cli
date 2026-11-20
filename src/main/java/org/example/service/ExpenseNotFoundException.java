package org.example.service;

public class ExpenseNotFoundException extends ExpenseTrackerException {
    public ExpenseNotFoundException(String message) {
        super(message);
    }

    public ExpenseNotFoundException(long id) {
        super("Expense with id " + id + " not found");
    }
}
