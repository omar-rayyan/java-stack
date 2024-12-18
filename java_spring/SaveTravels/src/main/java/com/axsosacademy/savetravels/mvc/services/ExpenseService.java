package com.axsosacademy.savetravels.mvc.services;

import java.util.List;
import java.util.Optional;

import com.axsosacademy.savetravels.mvc.models.Expense;
import com.axsosacademy.savetravels.mvc.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;


@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        return optionalExpense.orElse(null);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public void updateExpense(Expense expense) {
        expenseRepository.save(expense);
    }
}