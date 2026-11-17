# expense-tracker-cli

Command-line expense tracker with category reports and CSV persistence.
First stage of a three-step evolution: in-memory → JDBC → Spring Boot.

**Status:** work in progress — domain model and build setup.

## Tech Stack
Java 21 · Maven · JUnit 5

## Build
```bash
mvn clean test
```

## Design Decisions

- BigDecimal for money, never double — binary floating point cannot represent
  0.1 exactly; errors accumulate when summing expenses.
- Equality by identity, not by field values — two identical coffees bought on
  the same day are two distinct expenses, so equals/hashCode use the id only.