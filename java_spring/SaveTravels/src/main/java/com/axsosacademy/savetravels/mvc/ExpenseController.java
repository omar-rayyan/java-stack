package com.axsosacademy.savetravels.mvc;

import java.util.List;

import com.axsosacademy.savetravels.mvc.models.Expense;
import com.axsosacademy.savetravels.mvc.services.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String viewAllExpenses(Model model, @ModelAttribute("expense") Expense expense) {
        List<Expense> expenses = expenseService.allExpenses();
        model.addAttribute("expenses", expenses);
        return "index.jsp";
    }

    @PostMapping("/createexpense")
    public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("expenses", expenseService.allExpenses());
            return "index.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/";
        }
    }

    @RequestMapping(value="/expenses/edit/{id}", method=RequestMethod.GET)
    public String viewEditExpense(@ModelAttribute("expense") Expense expense, Model model, @PathVariable int id) {
        Expense expenseToEdit = expenseService.findExpense((long) id);
        model.addAttribute("expense", expenseToEdit);
        return "edit_expense.jsp";
    }

    @RequestMapping(value="/expenses/{id}", method=RequestMethod.GET)
    public String viewExpense(@ModelAttribute("expense") Expense expense, Model model, @PathVariable int id) {
        Expense expenseToEdit = expenseService.findExpense((long) id);
        model.addAttribute("expense", expenseToEdit);
        return "view_expense.jsp";
    }

    @PostMapping("/expenses/delete/{id}")
    public String deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense((long)id);
        return "redirect:/";
    }

    @PostMapping("/updateexpense/{id}")
    public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, @PathVariable int id) {
        if (result.hasErrors()) {
            return "edit_expense.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/";
        }
    }

}