package com.codingdojo.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class MainController {

	@Autowired
	private ExpenseService expenseServ;

	// just a redirect
	@GetMapping("/")
	public String redirectMe() {
		return "redirect:/expenses";
	}

	// /expenses
	// all the expenses
	@GetMapping("/expenses")
	public String allExpenses(Model model) {

		// Show all expenses
		List<Expense> allExpenses = expenseServ.allExpenses();
		model.addAttribute("allExpenses", allExpenses);
		

		// Set up Expense to be added to list
		Expense expenses = new Expense();
		model.addAttribute("expenses", expenses);

		return "index.jsp";
	}
	
	// POST - CREATE EXPENSE METHOD
	@PostMapping("/expenses")
	public String createExpense(@Valid @ModelAttribute("expenses") Expense expenses, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			// Show all expenses
			List<Expense> allExpenses = expenseServ.allExpenses();
			model.addAttribute("allExpenses", allExpenses);
			
			return "index.jsp";
		}
		else 
		{
			expenseServ.createExpense(expenses);
			return "redirect:/expenses";
		}
		
	}
}
