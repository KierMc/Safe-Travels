package com.kiernan.safetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	
	//attributes: expense, vendor, amount, description
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 1, max = 255, message="Expense needs to be more than 1 character and less than 255 characters.")
	private String expense;
	
	@NotEmpty
	@Size(min = 1, max = 255, message="Vendor needs to be more than 1 character and less than 255 characters.")
	private String vendor;
	
    @Min(value=0, message="Amount needs to be more than 0.")
    @NotNull
    private Double amount;
    
	@NotEmpty
	@Size(min = 1, max = 255, message="Description needs to be more than 1 character and less than 255 characters.")
	private String description;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	
	//constructors
	public Expense() {}
	
	public Expense(
		String expense, String vendor, Double amount, String description) {
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
//	public Expense(Long id,
//			@NotEmpty @Size(min = 1, max = 255, message = "Expense needs to be more than 1 character and less than 255.") String expense,
//			@NotEmpty @Size(min = 1, max = 255, message = "Vendor needs to be more than 1 character and less than 255.") String vendor,
//			@Min(value = 0, message = "Amount needs to be more than 0.") @NotNull Double amount, @NotEmpty @Size(min = 1, max = 255, message = "Description needs to be more than 1 character and less than 255.") String description) {
//		super();
//		this.id = id;
//		this.expense = expense;
//		this.vendor = vendor;
//		this.amount = amount;
//		this.description = description;
//	}
	
	//Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	//Other Methods
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
