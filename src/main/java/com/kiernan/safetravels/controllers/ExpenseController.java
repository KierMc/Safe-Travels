package com.kiernan.safetravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiernan.safetravels.models.Expense;
import com.kiernan.safetravels.services.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

	public final ExpenseService expenseServ;
	
	public ExpenseController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}
	
	@GetMapping("/all")
	public String allExpenses(Model model) {
		model.addAttribute("allExpenses", expenseServ.getAll());
		model.addAttribute("oneExpense", new Expense());
		return "showAll.jsp";
	}
	
	@GetMapping("/one/{id}")
	public String oneExpense(@PathVariable("id") Long id, Model model) {
		Expense oneExpense = expenseServ.findOne(id);
		model.addAttribute("oneExpense", oneExpense);
		return "showOne.jsp";
	}
	
	@PostMapping("/process")
	public String processExpense(@Valid @ModelAttribute("oneExpense") Expense expense, BindingResult result, Model model) {
		model.addAttribute("allExpenses", expenseServ.getAll());
		if(result.hasErrors()) {
			return "showAll.jsp";
		}
		expenseServ.create(expense);
		return "redirect:/expenses/all";
	}
	
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense expenseToBeEdited = expenseServ.findOne(id);
		model.addAttribute("oneExpense", expenseToBeEdited);
		return "editOne.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String processEditExpense(@Valid @ModelAttribute("oneExpense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "editOne.jsp";
		}
		expenseServ.update(expense);
		return "redirect:/expenses/all";
	}
	
	@DeleteMapping("/delete/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		expenseServ.deleteById(id);
		return "redirect:/expenses/all";
	}

}
