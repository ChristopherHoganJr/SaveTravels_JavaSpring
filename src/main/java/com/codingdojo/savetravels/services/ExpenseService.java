package com.codingdojo.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	// CRUD
	@Autowired
	private ExpenseRepository expenseRepo;
	
	// Read all the items pulled from the repo
	public List<Expense> allExpenses()
	{
		return expenseRepo.findAll();
	}
	
	// Create an expense
	public Expense createExpense(Expense e)
	{
		return expenseRepo.save(e);
	}
	
	// Read one
	public Expense findExpense(Long id)
	{
		Optional<Expense> tempEx = expenseRepo.findById(id);
		if (tempEx.isPresent())
		{
			return tempEx.get();
		}
		else 
		{
			return null;
		}
	}
	
	// Update
	public Expense updateExpense(Expense e)
	{
		return expenseRepo.save(e);
	}
	
	// Delete
	public void deleteBook(Long id)
	{
		expenseRepo.deleteById(id);
	}
}
