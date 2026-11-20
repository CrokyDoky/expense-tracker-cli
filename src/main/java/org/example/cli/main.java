package org.example;

import org.example.model.Category;
import org.example.model.Expense;
import org.example.repository.ExpenseRepository;
import org.example.repository.InMemoryExpenseRepository;
import org.example.service.ExpenseService;

import java.math.BigDecimal;
import java.time.LocalDate;


class Main {
     public static void main(String[] args) {
         ExpenseRepository repository = new InMemoryExpenseRepository();
         ExpenseService service = new ExpenseService(repository);

         Expense expense = service.save(new BigDecimal(120), Category.FOOD, LocalDate.now(), null);
         System.out.println(expense);

     }
}

