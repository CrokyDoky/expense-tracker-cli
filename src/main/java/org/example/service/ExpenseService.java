package org.example.service;

import org.example.model.Category;
import org.example.model.Expense;
import org.example.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public Expense save(BigDecimal amount, Category category, LocalDate date, String description) {
        if (amount == null) throw new InvalidExpenseException("Amount is null");
        if (amount.signum() <= 0) throw new InvalidExpenseException("Amount must be positive");
        if (amount.stripTrailingZeros().scale() > 2) throw new InvalidExpenseException("There should be no more than 2 decimal places");

        if (date == null) throw new InvalidExpenseException("Date is null");
        if (date.isAfter(LocalDate.now())) throw new InvalidExpenseException("Date is in the future");

        if (category == null) throw new InvalidExpenseException("Category is null");
        return repository.save(new Expense(null, amount, category, date, description));
    }

    public Expense findById(long id) {
        return repository.findById(id).orElseThrow(() -> new ExpenseNotFoundException("Expense not found"));
    }

    public List<Expense> findAll() {
        return repository.findAll();
    }

    public boolean deleteById(long id) {
        if (repository.deleteById(id)) {

        }
    }
}
