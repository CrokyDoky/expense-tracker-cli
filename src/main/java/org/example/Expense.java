package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Expense {
    private final int id;

    private BigDecimal amount;
    private Category category;
    private LocalDate date;
    private String description;

    public Expense(int id, BigDecimal amount, Category category, LocalDate date, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public int getId() {
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
    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-12s %-12s %10.2f  %s", id, category, date, amount, description);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense other)) return false;
        return this.id == other.id;
    }
}
