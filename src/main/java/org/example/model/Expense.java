package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Expense {
    private final Long id;

    private BigDecimal amount;
    private Category category;
    private LocalDate date;
    private String description;

    public Expense(Long id, BigDecimal amount, Category category, LocalDate date, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Expense withId(long id) {
        return new Expense(id, amount, category, date, description);
    }

    @Override
    public String toString() {
        return String.format("%-4d %-12s %-12s %10.2f  %s", id, category, date, amount, description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense other)) return false;
        if (id == null || other.id == null) return false;
        return this.id == other.id;
    }
}
