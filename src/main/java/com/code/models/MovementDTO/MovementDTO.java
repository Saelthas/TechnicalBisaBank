package com.code.models.MovementDTO;

import java.time.LocalDateTime;

public class MovementDTO {
	
	private Long idAccount;
	private String typeMovement;
    private Double amount;
    private String currency;
    public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Long getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTypeMovement() {
		return typeMovement;
	}
	public void setTypeMovement(String typeMovement) {
		this.typeMovement = typeMovement;
	}
	
}
