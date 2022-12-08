package com.kiernan.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kiernan.safetravels.models.Expense;
import com.kiernan.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepo;
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public Expense create(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public List<Expense> getAll() {
		return expenseRepo.findAll();
	}
	
	public Expense findOne(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	
	public Expense updateApi(Long id, String expense, String vendor, Double amount, String description) {
		Expense expenseToBeUpdated = expenseRepo.findById(id).orElse(null);
		expenseToBeUpdated.setExpense(expense);
		expenseToBeUpdated.setVendor(vendor);
		expenseToBeUpdated.setAmount(amount);
		expenseToBeUpdated.setDescription(description);
		return expenseRepo.save(expenseToBeUpdated);
	}
	
	public Expense update(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public String deleteById(Long id) {
		expenseRepo.deleteById(id);
		return "you deleted the record with the id of: " + id;
	}
	
}
