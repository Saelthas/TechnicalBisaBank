package com.code.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.code.exceptions.TestExceptions;
import com.code.mapper.AccountDTOTOAccount;
import com.code.mapper.MovementDTOTOMovement;
import com.code.models.Account;
import com.code.models.Movement;
import com.code.models.AccountDTO.AccountDTO;
import com.code.models.Balance.Balance;
import com.code.models.repositories.AccountRepository;
import com.code.models.repositories.MovementRepository;

@Service
public class AccountService {
	private final AccountRepository repositoryAccounts ;
	private final MovementRepository repositoryMovements ;
	private final AccountDTOTOAccount mapperAccount;
	
	
	public AccountService(AccountRepository _repository, AccountDTOTOAccount _mapperAccount,MovementRepository _repositoryMovements)
	{
		repositoryAccounts=_repository;
		repositoryMovements = _repositoryMovements;
		mapperAccount = _mapperAccount;
		
	}
	public Account CreateAccount(AccountDTO accountDTO)
	{
		Account account = mapperAccount.map(accountDTO);
		
		Account responseBD= repositoryAccounts.save(account);
		
		Movement movement = new Movement();
		movement.setAmount(accountDTO.getAmountStart());
		movement.setCurrentBalance(accountDTO.getAmountStart());
		movement.setCurrency(accountDTO.getCurrency());
		movement.setDateMovement(LocalDateTime.now());
		movement.setIdAccount(responseBD.getId());
		movement.setPreviusBalance((double) 0);
		movement.setTypeMovement("C");
		Movement responseMovBD= repositoryMovements.save(movement);
		
		return responseBD;
		
	}
	public List<Account> findAll ()
	{
		return repositoryAccounts.findAll();
	}
	public Optional<Account> findAccount(Long id)
	{
		return repositoryAccounts.findById(id);
	}
	public Balance GetBalanceAccount(Long id)
	{
		Optional<Account> respAccoBD = repositoryAccounts.findById(id);
		if(respAccoBD.isEmpty())
			throw new TestExceptions("Cuenta no encontrada", HttpStatus.NOT_FOUND);
		Optional<Movement> responseBD = repositoryMovements.findTop1ByIdAccountOrderByIdDesc(id);
		if(responseBD.isEmpty())
			throw new TestExceptions("Movimientos no encontrados", HttpStatus.NOT_FOUND);
		Balance balance = new Balance();
		balance.setAccount(respAccoBD.get().getAccount());
		balance.setBalance(responseBD.get().getCurrentBalance());
		balance.setCurrency(responseBD.get().getCurrency());
		balance.setIdAccount(id);
		return balance;
	}
}
