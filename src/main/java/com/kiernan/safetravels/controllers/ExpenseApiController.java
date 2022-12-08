package com.kiernan.safetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiernan.safetravels.models.Expense;
import com.kiernan.safetravels.services.ExpenseService;

@RestController
@RequestMapping("/")
public class ExpenseApiController {

	public final ExpenseService expenseServ;
	
	public ExpenseApiController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}
	
	//Find All
	@GetMapping("/expenses")
	public List<Expense> findAllExpenses() {
		return expenseServ.getAll();
	}
	
	//Create One
	@PostMapping("/expenses")
	public Expense createDonation(@RequestParam("expense") String expense, @RequestParam("vendor") String vendor, @RequestParam("amount") Double amount, @RequestParam("description") String description) {
		Expense newDonation = new Expense (expense, vendor, amount, description);
		return expenseServ.create(newDonation);
	}
	
	//Find One
	@GetMapping("/expenses/{id}")
	public Expense findOneExpense(@PathVariable("id") Long id) {
		return expenseServ.findOne(id);
	}
	
	//Edit One
	@PutMapping("/expenses/{id}")
	public Expense findOneAndUpdate(@PathVariable("id") Long id, @RequestParam("expense") String expense, @RequestParam("vendor") String vendor, @RequestParam("amount") Double amount, @RequestParam("description") String description) {
		return expenseServ.updateApi(id, expense, vendor, amount, description);
	}
	
	//Delete One
	@DeleteMapping("/expenses/{id}")
	public String delete(@PathVariable("id") Long id) {
		return expenseServ.deleteById(id);
	}
	
	
}
