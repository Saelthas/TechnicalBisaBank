package com.code.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.models.Account;
import com.code.models.AccountDTO.AccountDTO;
import com.code.models.Balance.Balance;
import com.code.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	private final AccountService accountService;
	
	public AccountsController(AccountService _accountService)
	{
		accountService=_accountService;
	}
	
	@PostMapping
	public Account createAccount(@RequestBody AccountDTO accountDTO)
	{
		return accountService.CreateAccount(accountDTO);
	}
	
	@GetMapping
	public List<Account>findAll()
	{
		return accountService.findAll();
	}
	@GetMapping("/account/{id}")
	public Optional<Account> AccountfindAccountById(@PathVariable("id") Long id)
	{
		return accountService.findAccount(id);
	}
	@GetMapping("/account/Balance/{id}")
	public Balance AccountBalanceById(@PathVariable("id") Long id)
	{
		return accountService.GetBalanceAccount(id);
	}
}
