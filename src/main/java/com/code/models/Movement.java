package com.code.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movement")
public class Movement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long idAccount;
    private LocalDateTime dateMovement;
    private String typeMovement; //"D"Debit-"C" Credit
    private Double amount;
    private String currency;
    private Double previusBalance;
    public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	private Double currentBalance;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}
	public LocalDateTime getDateMovement() {
		return dateMovement;
	}
	public void setDateMovement(LocalDateTime dateMovement) {
		this.dateMovement = dateMovement;
	}
	public String getTypeMovement() {
		return typeMovement;
	}
	public void setTypeMovement(String typeMovement) {
		this.typeMovement = typeMovement;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getPreviusBalance() {
		return previusBalance;
	}
	public void setPreviusBalance(Double previusBalance) {
		this.previusBalance = previusBalance;
	}
	public Double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

}
