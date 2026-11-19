package org.example.repository;

import org.example.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {
    Expense save(Expense expense);
    Optional<Expense> findById(long id);
    List<Expense> findAll();
    boolean deleteById(long id);
}
