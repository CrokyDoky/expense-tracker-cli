package org.example.repository;

import org.example.model.Expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryExpenseRepository implements ExpenseRepository {
    private Map<Long, Expense> storage = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public Expense save(Expense draft) {
        if (draft.getId() == null) {
            long id = sequence.incrementAndGet();
            Expense expense = draft.withId(id);
            storage.put(id, expense);
            return expense;
        } else {
            storage.put(draft.getId(), draft);
            return draft;
        }
    }

    @Override
    public Optional<Expense> findById(long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Expense> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public boolean deleteById(long id) {
        return storage.remove(id) != null;
    }
}
