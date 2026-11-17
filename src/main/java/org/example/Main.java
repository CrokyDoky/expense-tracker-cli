package org.example;
import java.math.BigDecimal;
import java.time.LocalDate;

class Main {
     static void main() {
         Expense expense = new Expense(1, new BigDecimal(120), Category.FOOD, LocalDate.now(), "testing");
         System.out.println(expense.toString());
         System.out.println(expense.hashCode());
    }
}

