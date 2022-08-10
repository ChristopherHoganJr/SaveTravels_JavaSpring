package com.codingdojo.savetravels.repositories;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.savetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	// This will retrieve everything from DB
	List<Expense> findAll();	

	
}
