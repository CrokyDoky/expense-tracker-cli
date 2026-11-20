package org.example.service;

import org.example.model.Category;
import org.example.model.Expense;
import org.example.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ExpenseService {
    private static final int MAX_DESCRIPTION_LENGTH = 100;

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public Expense save(BigDecimal amount, Category category, LocalDate date, String description) {
        if (amount == null) throw new InvalidExpenseException("Amount is null");
        if (amount.signum() <= 0) throw new InvalidExpenseException("Amount must be positive");
        if (amount.stripTrailingZeros().scale() > 2) throw new InvalidExpenseException("Amount must have at most 2 decimal places");

        if (date == null) throw new InvalidExpenseException("Date is null");
        if (date.isAfter(LocalDate.now())) throw new InvalidExpenseException("Date is in the future");

        if (category == null) throw new InvalidExpenseException("Category is null");

        if (description == null) throw new InvalidExpenseException("Description is null");
        String strippedDesc = description.strip();
        if (strippedDesc.isEmpty()) throw new InvalidExpenseException("Description is empty");
        if (strippedDesc.length() > MAX_DESCRIPTION_LENGTH) throw new InvalidExpenseException("Description max length is " + MAX_DESCRIPTION_LENGTH + " characters");
        return repository.save(new Expense(null, amount, category, date, strippedDesc));
    }

    public Expense getById(long id) {
        return repository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));
    }

    public List<Expense> findAll() {
        return repository.findAll();
    }

    public void deleteById(long id) {
        if (!repository.deleteById(id)) {
            throw new ExpenseNotFoundException(id);
        }
    }
}
