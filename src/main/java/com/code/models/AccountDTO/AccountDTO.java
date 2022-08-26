package com.code.models.AccountDTO;

import lombok.Data;

//@Data
public class AccountDTO {
	
    private int idClient;
	private String clientName;
    private String account;
    private String currency;
    private double amountStart;
    public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getAmountStart() {
		return amountStart;
	}
	public void setAmountStart(double amountStart) {
		this.amountStart = amountStart;
	}
}
